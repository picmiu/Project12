<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ㅎㅇ</title>
</head>
<%@include file="../common/header.jsp"%>
<body>
	<div align="center">
		<div><h1>로 그 인</h1></div>
		<div>
			<form id="frm" name="frm" action="LoginCheck.do" method="post">
				<table border="1">
					<tr>
						<th>아 이 디</th>
						<td><input type="text" id="td" name="id" size="20"></td>
					</tr>
					<tr>
						<th>패 스 워 드</th>
						<td><input type="password" id="password" name="password" size="20"></td>
					</tr>
				</table>
				<br/>
				<input type="submit" value="로그인"> &nbsp;&nbsp;&nbsp;
				<input type="reset" value="취 소"> &nbsp;&nbsp;&nbsp;
			</form>
		</div>
	</div>
</body>
<%@include file="../common/tail.jsp"%>
</html>