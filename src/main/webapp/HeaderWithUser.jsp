<%@page import="domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>HeaderWithUser</title>
</head>
<body>

	<!-- 导航栏 -->
	<header class="navbar navbar-default navbar-fixed-top"> <nav
		class="navbar navbar-default" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button data-toggle="collapse" data-target="#header-navbar"
				type="button" class="navbar-toggle">
				<span class="sr-only">Toggle Navigation</span><span class="icon-bar"></span><span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<button data-toggle="collapse" data-target="#notice-navbar"
				type="button" id="notice-navbar-button"
				class="navbar-toggle notice-navbar-button">
				<i class="fa fa-bell"></i>
			</button>
			<a href="index.jsp" style="padding: 0;" class="navbar-brand"> <img
				src="image/123.jpg" style="height: 52px"></a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li><a href="#">书籍评论</a></li>
				<li><a href="shuku.jsp">书库</a></li>
			</ul>
		</div>
		<!-- 搜书form -->
		<form id="globalsearchform" role="search" onsubmit=""
			class="navbar-form navbar-left">
			<div style="" class="input-group">
				<div class="input-group-btn">
					<button type="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false" class="btn btn-default dropdown-toggle">
						<span id="globalsearchform_typetext">综合</span>&nbsp; <span
							class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#" data-type="book" onclick="">书名搜索</a></li>
						<li><a href="javascript:;" data-type="author" onclick="">作者搜索</a></li>
						<li><a href="javascript:;" data-type="booklist" onclick="">书单搜索</a></li>
						<li><a href="javascript:;" data-type="user" onclick="">用户搜索</a></li>
						<li class="divider"></li>
						<li><a href="javascript:;" data-type="all" onclick="">综合搜索</a></li>
					</ul>
				</div>
				<input id="globalsearchtype" type="hidden" name="searchType"
					value="all"> <input id="globalsearchtxt" type="text"
					name="searchTextInput" placeholder="输入书名/作者名/用户/书单"
					class="form-control"> <span class="input-group-btn">
					<button type="button" onclick="" class="btn btn-default">搜索</button>
				</span>
			</div>
		</form>
		<div>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <%String touxiang="'"+((User)session.getAttribute("user")).getTouxiang()+"'"; %>
						<img alt='..' src=<%out.print(touxiang); %> width="20" height="20">
						<%out.print(((User)session.getAttribute("user")).getUserName()); %>
						<b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">个人书架</a></li>
						<li><a href="#">我的书单</a></li>
						<li><a href="Setting.jsp">个人设置</a></li>
						<li class="divider"></li>
						<li><a href="process_out.jsp">退出登录</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	</nav> </header>


</body>
</html>