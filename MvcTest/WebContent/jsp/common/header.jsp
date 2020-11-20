<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
			background-color: #333;
		}
		ul:after{
			content:'';
			display: block;
			clear:both;
		}
		li {
			float: left;
		}
		li a {
			display: block;
			color: white;
			text-align: center;
			padding: 14px 16px;
			text-decoration: none;
		}
		li a:hober:not(.active) {
			background-color: #111;
		}
		.active {
			background-color: #4CAF50;
		}
	</style>
</head>
<body>
	<div align="center">
		<div><h1>이곳은 메뉴 부분 입니다.</h1></div>
		<hr>
		<ul>
			<li><a class="active" href="../main/main.jsp">Home</a></li>
			<li><a href="#news">News</a></li>
			<li><a href="#contact">Contact</a></li>
			<li><a href="#about">About</a></li>
			<li><a href="LoginForm.do">Login</a></li>
		</ul>
	</div>
</body>
</html>