<%@page import="domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css">
        .xh-carousel-content {
            max-width:690px;
            max-height: 370px;
        }
        @media (max-width: 690px) {
            .xh-carousel-content {
                width: 100%;
                height: 100%;
                max-width: 100%;
                max-height: 100%;
            }
        }
    </style>
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
	<div class="container">
        <div class="row" align="center">
        <div id="carousel-example-generic" data-ride="carousel" class="carousel slide" >
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class=""></li>
                <li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
                <li data-target="#carousel-example-generic" data-slide-to="2" class="active"></li>
            </ol>

            <div class="carousel-inner">
                <div class="item">
                    <div class="xh-carousel-content">
                    <a href="pinlun_to_book.jsp?book=25" >
                        <img src="image/qingshi.jpg" class="img-responsive"></a>
                    <div class="carousel-caption">史记</div>
                    </div>
                    </div>
                <div class="item">
                    <div class="xh-carousel-content">
                        <a href="pinlun_to_book.jsp?book=16">
                            <img src="image/lienv.jpeg" class="img-responsive"></a>
                    <div class="carousel-caption">列女传</div>
                    </div>
                   </div>
                <div class="item active">
                    <div class="xh-carousel-content">
                        <a href="pinlun_to_book.jsp?book=1">
                            <img src="image/sanguo.jpg" class="img-responsive"></a>
                    <div class="carousel-caption">三国志</div>
                    </div>
                </div>
            </div>
            <a href="#carousel-example-generic" data-slide="prev" class="carousel-control left">
                <span class="glyphicon glyphicon-chevron-left"></span></a>
            <a href="#carousel-example-generic" data-slide="next" class="carousel-control right">
                <span class="glyphicon glyphicon-chevron-right"></span></a>
        </div>
        </div>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>