<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>

<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>阅读-古籍网</title>
<link rel="Shortcut Icon" href="image/guji.ico">
</head>
<%!


public int getAlltxt(String mulu){
	File file=new File(mulu);
	String files[];
	files=file.list();
	 int num=0;
	for(int i=0;i<files.length;i++)
	{
		if(files[i].endsWith(".txt")){
			  num++;
		}
		else if(!files[i].contains(".")){
			num+=getAlltxt(mulu+files[i]+"/");
		}
		else{
			
		}
	}  
	return num;
}

public String[] getAlltxtName(String mulu,int num){
	String[] s=new String[num];
	int temp=0;
	File file=new File(mulu);
	String files[];
	files=file.list();
	for(int i=0;i<files.length;i++)
	{
		if(files[i].endsWith(".txt")){
			  s[temp++]=mulu+files[i];
		}
		else if(!files[i].contains(".")){
			int temp1=getAlltxt(mulu+files[i]+"/");
			String[] temps=getAlltxtName(mulu+files[i]+"/",temp1);
			for(int j=0;j<temps.length;j++){
				 s[temp++]=temps[j];
			}
		}
		else{
			
		}
	}  
	return s;
}

%>
<body>

<% User user=(User)session.getAttribute("user");
	if(user!=null){%>
<%@ include file="HeaderWithUser.jsp"%>
<%}else{ %>
<%@ include file="Header.jsp"%>
<%} %>
<div class="container" style="padding-top:90px"><div class="row"><div>

	<%        
   String s=this.getServletContext().getRealPath("/");
   String pages=request.getParameter("page"); 
   int num=getAlltxt(s);
   String[] allname=getAlltxtName(s, num);
     if(pages==null)  
           pages="0";  
     String books=request.getParameter("book");  
     String bookname=request.getParameter("book"); 
     if(books==null)  
           books=s+"books/放开那个女巫.txt"; 
     else{
    	 int temp=Integer.parseInt(books);
    	 books=allname[temp];
     }
   int diPage=Integer.parseInt(pages);    %>
	<%     int pageFileSize=100;//每页显示100行数据   
     int fileLineCount=0;//文件总行数   
     int fileCountPage=0;//文件页数    
     File f=new File(books);  
     if(f.exists())//得到文件总行数  
     {      FileReader fileReader1=new FileReader(f);    
     BufferedReader buffer1=new BufferedReader(fileReader1);   
     String tempString=null;   
     while((tempString=buffer1.readLine())!=null)  
     {          fileLineCount++;
}    
     buffer1.close();  
     fileReader1.close();   
     }     %>
	<p align="center">
		<span style="font-weight: bold; font-size: 24px;"> <%=f.getName().substring(0,f.getName().lastIndexOf("."))
    %>
		</span>
	</p>
	本页字数:
	<span id="count"></span>
	<br>
	<p id="txtValue">
		<% 
     //得到文件页数     
if(fileLineCount%pageFileSize==0)   
	fileCountPage=fileLineCount/pageFileSize; 
else        
	fileCountPage=fileLineCount/pageFileSize+1;    
     //读取当前文件的总数  
     if(f.exists())    {      
     BufferedReader buffer1= new BufferedReader(new InputStreamReader(new FileInputStream(f)));
     String tempString=null;    
     for(int i=0;i<=diPage*pageFileSize;i++)      
    	 buffer1.readLine(); //读取当前页前一页的内容，这样读取结束后，buffer1指向当前页。
    	 for(int i=0;i<pageFileSize&&(tempString=buffer1.readLine())!=null;i++){
    		 if(!tempString.isEmpty())
    	 out.println(tempString+"<br>");  
    		 else
    			 i--;
    		 }
    	 buffer1.close();        
    		 }   
     else    
     {        out.println("<p align='center'>"+"文章中没有内容"+"</p>");    }    %>
	</p>
	<p align="center">
		<%        if(diPage>0)    {%>
		<a href="fenye.jsp?book=<%=bookname %>&&page=<%=diPage-1%>">上一页</a>
		<%}    %>
		<%        if(diPage<fileCountPage)    {%>
		<a href="fenye.jsp?book=<%=bookname %>&&page=<%=diPage+1%>">下一页&nbsp;&nbsp;</a>
		共<%=fileCountPage%>页,当前第<%=diPage+1%>页
		<%}  %>
		<input type="text" id="whatnum" style="width: 50px" /> <input
			type="button" name="tiaozhuan" value="跳转" onclick="tiaozhuan()" />


		<script type="text/javascript">
 function tiaozhuan(){
	var num= document.getElementById("whatnum");
	var n=Number(num.value)-1;
	if(n<<%=fileCountPage%>)
    window.location.href="fenye.jsp?book=<%=bookname %>&&page="+n;
 }
 function fnGetCpmisWords(str){  
	    sLen = 0;  
	    try{  
	        //先将回车换行符做特殊处理  
	        str = str.replace(/(\r\n+|\s+|　+)/g,"龘");  
	        //处理英文字符数字，连续字母、数字、英文符号视为一个单词  
	        str = str.replace(/[\x00-\xff]/g,"m");    
	        //合并字符m，连续字母、数字、英文符号视为一个单词  
	        str = str.replace(/m+/g,"*");  
	        //去掉回车换行符  
	        str = str.replace(/龘+/g,"");  
	        //返回字数  
	        sLen = str.length;  
	    }catch(e){  
	          
	    }  
	    return sLen;  
	}  
 function setCount()
 {
     var txt = document.getElementById("txtValue");
     document.getElementById("count").innerText=fnGetCpmisWords(txt.innerText)+"";
 }
setInterval('setCount()',10); 
</script>
</div></div></div>
</body>
</html>