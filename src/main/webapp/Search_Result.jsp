<%@ page import="service.imp.UserService" %>
<%@ page import="service.imp.BookService" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.Book" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>评论-古籍网</title>
    <link rel="Shortcut Icon" href="image/guji.ico">
</head>
<body>
<% User user=(User)session.getAttribute("user");
    if(user!=null){%>
<%@ include file="HeaderWithUser.jsp"%>
<%}else{ %>
<%@ include file="Header.jsp"%>
<%} %>

<%
    UserService userService=new UserService();
    BookService bookService=new BookService();
    List<Book> books=bookService.searchBooks(request.getParameter("input"));
%>
<div class="container"><%if(books.size()==0){%>

    <ul class="media-list ys-comments">
        <li class="media ys-comments-left">
            <div style="margin-right: 5px;" class="ys-comments-main">
                <div class="media-body">
                    <h5 class="media-heading">搜索结果为空</h5>
                    <div class="ys-comments-message">
                        <p>请重新输入来搜索！</p>
                    </div>
                </div>
            </div>
        </li>
    </ul>
    <%}else{ %>

    <div class="row">
        <%for(Book tempbook:books){%>

        <div class="col-lg-4 col-md-6 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <p>
                        <img src='image/timg.jpg'
                             style='max-height: 125px; max-width: 100px;'>
                    </p>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <% out.println("书名:<a href='pinlun_to_book.jsp?book="+tempbook.getLujing()+"'>");
                            out.println(tempbook.getBookname().split("-")[0]+"</a><br>"); %>
                    </li>
                    <li class="list-group-item">
                        <% out.println("朝代:"+tempbook.getBookname().split("-")[1]+"<br>"); %>
                    </li>
                    <li class="list-group-item">
                        <% out.println("作者:"+tempbook.getBookname().split("-")[2].split("\\.")[0]+"<br>"); %>
                    </li>
                    <li class="list-group-item">
                        <% out.println("字数:"+tempbook.getZishu()+"<br>"); %>
                    </li>
                </ul>
            </div>
        </div>
        <%}}%>

    </div>
</div>
<%@ include file="Footer.jsp"%>
</body>
</html>