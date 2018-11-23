<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="service.imp.User_BookService" %>
<%@ page import="domain.User_Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>从书架移除</title>
</head>
<body>
    <%
    User_BookService user_bookService=new User_BookService();
        User_Book user_book=new User_Book();
        user_book.setBookId(request.getParameter("bookId").trim());
        user_book.setUserId(request.getParameter("userId").trim());
        user_bookService.alterUser_Book(user_book);
    %>
<script type="text/javascript">
    alert("从我的书架移除成功！");
    <% if(!(request.getParameter("book")==null)){%>
    window.location.href='pinlun_to_book.jsp?book='+<%out.print(request.getParameter("book"));%>;
    <%}else {%>
    window.location.href='UserBook.jsp';
    <%}%>
</script>
</body>
</html>