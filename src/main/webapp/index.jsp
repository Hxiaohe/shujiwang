<%@page import="domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页-古籍网</title>
<link rel="Shortcut Icon" href="image/guji.ico">
</head>
<body>
	<% User user=(User)session.getAttribute("user"); 
   if(user!=null){%>
	<%@ include file="HeaderWithUser.jsp"%>
	<%}else{ %>
	<%@ include file="Header.jsp"%>
	<%} %>
	<div align="center">
		<img src="image/gufeng.jpg" width="1000" height="800">
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>