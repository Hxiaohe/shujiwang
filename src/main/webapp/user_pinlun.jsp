<%@ page import="service.imp.UserService" %>
<%@ page import="service.imp.BookService" %>
<%@ page import="service.imp.CommandService" %>
<%@ page import="domain.Command" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的评论-古籍网</title>
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
    CommandService commandService=new CommandService();
    String userId ="";
    if(user!=null) {
        userId=userService.getUserByName(user.getUserName()).get(0).getId();
    }
    List<Command> commands=commandService.getCommandByUserId(userId);
%>
<div class="container"><%if(commands.size()==0){%>

    <ul class="media-list ys-comments">
        <li class="media ys-comments-left">
            <div style="margin-right: 5px;" class="ys-comments-main">
                <div class="media-body">
                    <h5 class="media-heading">您暂无书评</h5>
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
<%@ include file="Footer.jsp"%>
</body>
</html>