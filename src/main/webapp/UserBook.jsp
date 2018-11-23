<%@ page import="java.util.List" %>
<%@ page import="service.imp.User_BookService" %>
<%@ page import="domain.User_Book" %>
<%@ page import="service.imp.UserService" %>
<%@ page import="service.imp.BookService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的书架-古籍网</title>
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
    User_BookService user_bookService=new User_BookService();
    UserService userService=new UserService();
    BookService bookService=new BookService();
    List<User_Book> user_books=user_bookService.getUser_BookByUserId(userService.getUserByName(user.getUserName()).get(0).getId());
%>
<div class="container" style="padding-top:90px">
    <% if(user_books.size()==0){%>

    <ul class="media-list ys-comments">
        <li class="media ys-comments-left">
            <div style="margin-right: 5px;" class="ys-comments-main">
                <div class="media-body">
                    <h5 class="media-heading">你的书架暂无书籍</h5>
                    <div class="ys-comments-message">
                        <p>欢迎你添加喜欢的书！</p>
                    </div>
                </div>
            </div>
        </li>
    </ul>
    <%}else{%>

    <div class="row">
        <div class="table-responsive11">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>书名</th>
                    <th class="hidden-xs">作者</th>
                    <th>朝代</th>
                    <th style="width:6em;" class="hidden-xs">阅读链接</th>
                    <th style="width:6em;" class="hidden-xs">从书架移除</th>
                </tr>
                </thead>
                <tbody>
                <% for (User_Book user_book:user_books){%>
                <tr >
                    <td><a href=<%out.print("pinlun_to_book.jsp?book="+bookService.getBookByID(user_book.getBookId()).getLujing());%>><%out.print(bookService.getBookByID(user_book.getBookId()).getBookname().split("-")[0]);%></a></td>
                    <td class="hidden-xs"><%out.print(bookService.getBookByID(user_book.getBookId()).getBookname().split("-")[2].split("\\.")[0]);%></td>
                    <td><%out.print(bookService.getBookByID(user_book.getBookId()).getBookname().split("-")[1]);%></td>
                    <td class="hidden-xs"> <a href=<%out.print("fenye.jsp?book="+bookService.getBookByID(user_book.getBookId()).getLujing());%>>点击阅读</a></td>
                    <td class="hidden-xs"> <a href=<%out.print("process_deleteBookToUser.jsp?userId="+userService.getUserByName(user.getUserName()).get(0).getId()+"&&bookId="+user_book.getBookId());%>>取消收藏</a></td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
    <%}%>
</div>
<%@ include file="Footer.jsp"%>
</body>
</html>