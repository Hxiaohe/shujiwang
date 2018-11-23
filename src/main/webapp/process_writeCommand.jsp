<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="domain.Command" %>
<%@ page import="service.imp.CommandService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>书评</title>
</head>
<body>
<%
    CommandService commandService=new CommandService();
    if(!Boolean.parseBoolean(request.getParameter("isCommand"))){
        Command command=new Command();
        command.setContent(request.getParameter("content"));
        command.setBookId(request.getParameter("bookId").trim());
        command.setUserId(request.getParameter("userId").trim());
        commandService.addCommand(command);
    }else {
        Command command=commandService.getCommandBybookIdAndUserId(request.getParameter("bookId").trim(),request.getParameter("userId").trim());
        command.setContent(request.getParameter("content"));
        commandService.alterCommand(command);
    }
%>
<script type="text/javascript">
    alert("分享书评成功！");
    window.location.href='pinlun_to_book.jsp?book='+<%out.print(request.getParameter("book"));%>;
</script>
</body>
</html>