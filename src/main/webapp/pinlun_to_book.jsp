<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="domain.Book"%>
<%@page import="domain.Command"%>
<%@ page import="java.io.*"%>
<%@page import="service.imp.BookService"%>
<%@page import="service.imp.CommandService"%>
<%@ page import="java.util.List" %>
<%@ page import="service.imp.UserService" %>
<%@ page import="service.imp.User_BookService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>评论-古籍网</title>
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
    public int getWordsNum(String mulu){
        int num=0;
        File file=new File(mulu);
        if(file.exists())//得到文件总行数
        {
            try{
                FileReader fileReader1=new FileReader(file);
                BufferedReader buffer1=new BufferedReader(fileReader1);
                String tempString=null;
                while((tempString=buffer1.readLine())!=null)  {
                    num+=tempString.length();
                }
                buffer1.close();
                fileReader1.close();
            }
            catch(IOException e){

            }

        }
        return num;
    }

    public String[] getAlltxtDe(String s,int num){
        String[] ss=new String[num];
        int temp=0;
        File file=new File(s);
        String files[];
        files=file.list();
        for(int i=0;i<files.length;i++)
        {
            if(files[i].endsWith(".txt")){
                ss[temp++]=s+files[i];
            }
            else if(!files[i].contains(".")){
                int temp1=getAlltxt(s+files[i]+"/");
                String[] temps=getAlltxtDe(s+files[i]+"/",temp1);
                for(int j=0;j<temps.length;j++){
                    ss[temp++]=temps[j];
                }
            }
            else{

            }
        }
        return ss;
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
                s[temp++]=files[i];
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
<%
    UserService userService=new UserService();
    BookService bookService=new BookService();
    CommandService commandService=new CommandService();
    User_BookService user_bookService=new User_BookService();
    String pages=request.getParameter("page");
    if(pages==null)
        pages="0";
    String s=this.getServletContext().getRealPath("/");
    int num=getAlltxt(s);
    String[] allname=getAlltxtName(s, num);
    String[] de=getAlltxtDe(s, num);
    String books=request.getParameter("book");
    String bookname=request.getParameter("book");
    int zishu=0;
    if(books==null)
        books=s+"books/放开那个女巫.txt";
    else{
        int temp=Integer.parseInt(books);
        zishu=getWordsNum(de[temp]);
        books=allname[temp];
    }

%>
<% User user=(User)session.getAttribute("user");
    if(user!=null){%>
<%@ include file="HeaderWithUser.jsp"%>
<%}else{ %>
<%@ include file="Header.jsp"%>
<%} %>

<%
    List<Book> tempbooks=bookService.getBookBybookName(books);
    String bookId=tempbooks.get(0).getId();
    List<Command> commands=commandService.getCommandByBookId(bookId);
    boolean isCommand =false;
    boolean isAddBookToUser =false;
    if(user!=null) {
        List<User> users = userService.getUserByName(user.getUserName());
        String userId = users.get(0).getId();
        isCommand=commandService.isBybookIdAndUserId(bookId, userId);
        isAddBookToUser=user_bookService.isUser_Book(userId,bookId);
    }
%>
<div class="container">
<div class="row">
    <div class="col-sm-7">
        <div style="height:30px;line-height:30px;">
            <span style="font-size:18px;font-weight:bold;"><% out.println(books.split("-")[0]);%></span>
        </div>
        <div class="media">
            <% out.println("<a href='fenye.jsp?book="+bookname+"' class='hidden-xs pull-left'>"); %>
                <img src='image/timg.jpg' class="bookavatar">
                <button style="margin-top:-3px" class="btn btn-primary btn-block">开始阅读</button></a>
            <% out.println("<a href='fenye.jsp?book="+bookname+"' class='visible-xs pull-left'>"); %>
                <img src='image/timg.jpg' class="bookavatar">
                <button style="margin-top:-3px" class="btn btn-primary btn-block">开始阅读</button></a>

            <div class="media-body ys-bookmain">
                <ul class="list-unstyled list-sm">
                    <li><% out.println("作者:"+books.split("-")[2]);%></li>
                    <li><% out.println("字数:"+zishu);%> </li>
                    <li><% out.println("朝代:"+books.split("-")[1]);%> </li>
                </ul>
            </div></div></div>
    </div>
<div class="col-sm-5 col-sm-push-7"><div></div></div>
<div class="col-sm-7 col-sm-pull-5"><div class="sokk-book-button-groups">
    <%if(user!=null){%>
    <% if(!isAddBookToUser){%>
    <div class="btn-group"><button onclick="" class="btn btn-warning"><a style=" text-decoration:none;color:black;" href=<%out.print("process_addBookToUser.jsp?userId="+userService.getUserByName(user.getUserName()).get(0).getId()+"&&bookId="+bookId+"&&book="+bookname);%>>加入我的书架</a></button></div>
    <%}else {%>
    <div class="btn-group"><button onclick="" class="btn btn-warning"><a style=" text-decoration:none;color:black;" href=<%out.print("process_deleteBookToUser.jsp?userId="+userService.getUserByName(user.getUserName()).get(0).getId()+"&&bookId="+bookId+"&&book="+bookname);%>>从我的书架移除</a></button></div>
    <%}%>
    <% if(!isCommand){%>
    <div class="btn-group"><a  href="#" data-target="#writeshupin-modal-sm" data-toggle="modal" class="btn btn-default active">写书评</a></div>
    <%}else {%>
    <div class="btn-group"><a href="#" data-target="#writeshupin-modal-sm" data-toggle="modal" class="btn btn-default active">修改书评</a></div>
    <%}}else{ %>
    <div class="btn-group"><button onclick="ys.book.tobooklist();" data-toggle="tooltip"
                                   data-placement="top" title="请登录" class="btn btn-warning disabled">加入我的书架</button></div>
    <div class="btn-group" data-toggle="tooltip" data-placement="top" title="请登录"><a href="#" data-target="#writeshupin-modal-sm"  data-toggle="modal" class="btn btn-default active disabled">写书评</a></div>
    <%} %>
</div>
</div>
<%if(commands.size()==0){%>

<ul class="media-list ys-comments">
    <li class="media ys-comments-left">
        <div style="margin-right: 5px;" class="ys-comments-main">
            <div class="media-body">
                <h5 class="media-heading">本书暂无书评</h5>
                <div class="ys-comments-message">
                    <p>欢迎你进行评价！</p>
                </div>
            </div>
        </div>
    </li>
</ul>
<%}else{ %>

<div class="row">
    <%for(Command tempcommand:commands){%>

        <%User tempuser=userService.getUserByID(tempcommand.getUserId());%>
        <div class="col-sm-6 col-lg-4 col-xs-12">
            <div class="thumbnail">
                <div class="caption">
                    <div style="margin-right: 5px;" class="media clearfix"><img
                            src=<%out.print(tempuser.getTouxiang());%> width="50" class="pull-left">
                        <div class="media-body"><span class="media-heading"><%out.print(tempuser.getUserName());%></span></div>
                    </div>
                    <p class="commentcontent"><%out.print(tempcommand.getContent());%> </p>
                    <div class="clearfix">
                        <div class="pull-right">
                            <small>&nbsp;(本书评来自于 <a href=""><%out.print(bookService.getBookByID(tempcommand.getBookId()).getBookname().split("-")[0]);%>
                            </a>)
                            </small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<%}}%>

</div>
</div>
<div id="writeshupin-modal-sm" tabindex="-1" role="dialog"
     aria-labelledby="shupingModalLabel" aria-hidden="true"
     data-backdrop="false" class="modal fade">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close">
                    <span aria-hidden="true">&times;</span> <span class="sr-only">关闭</span>
                </button>
                <h4 id="shupingModalLabel" class="modal-title">写书评</h4>
            </div>
            <div class="modal-body">
                <p style="margin: 5px 0; padding: 10px;" class="bg-info">为<% out.println(books.split("-")[0]);%>写书评</p>
                <div style="border-color:#3cf;border-width:2px;" class="thumbnail">
                    <div class="caption">
                <form onsubmit="" class="form" action="process_writeCommand.jsp">
                    <div class="media">
                        <input type="hidden" name="bookId" value=<%out.print(bookId);%>>
                        <%if(user!=null){%>
                        <input type="hidden" name="userId" value=<%out.print(userService.getUserByName(user.getUserName()).get(0).getId());%>>
                        <%}else{ %>
                        <%} %>
                        <input type="hidden" name="book" value=<%out.print(bookname);%>>
                        <input type="hidden" name="isCommand" value=<%out.print(isCommand);%>>
                        <button class="pull-right btn btn-primary btn-sm">发表书评</button>
                        <%if(user!=null){%>
                        <img src=<%out.print(((User)session.getAttribute("user")).getTouxiang());%> onerror="this.src='image/girl.jpg';this.onerror=null;" class="img-rounded" width="30" height="30">
                        <div class="media-body">
                            <span class="media-heading"><%out.print(((User)session.getAttribute("user")).getUserName()); %></span><br></div></div>
                    <textarea id="fastwritecotentinput" style="margin-top:5px;height:100px;" name="content" placeholder="短评,最多不能超过200字" class="form-control"></textarea>
                        <%}else{ %>
                    <img src="image/girl.jpg" onerror="this.src='image/girl.jpg';this.onerror=null;" class="img-rounded">
                    <div class="media-body">
                        <span class="media-heading">萧何月下</span><br></div></div>
                    <textarea id="fastwritecotentinput" style="margin-top:5px;height:100px;" name="content" placeholder="短评,最多不能超过200字" class="form-control"></textarea>
                        <%} %>
                    </form>
                </div></div>
            </div>
            <div class="modal-footer">
                <button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
            </div>
        </div>
    </div>
</div>
<%@ include file="Footer.jsp"%>

<script type="text/javascript">
</script>
</body>
</html>