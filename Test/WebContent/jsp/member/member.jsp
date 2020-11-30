<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입 화면</title>

<style>
#wrap {
	width: 530px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

#title {
	background-color: skyblue
}
</style>
</head>
<body>
	<!-- 왼쪽, 오른쪽 바깥여백을 auto로 주면 중앙정렬된다.  -->
	<div id="wrap">
		<br> <br> <b><font size="6" color="gray">회원가입</font></b> <br>
		<br> <br>
		<form>
			<table align ="center">
				<tr>
					<td id="title">회원 ID</td>
					<td><input type="text" name="id" maxlength="20"></td>
				</tr>

				<tr>
					<td id="title">회원 명</td>
					<td><input type="text" name="name" maxlength="40"></td>
				</tr>

				<tr>
					<td id="title">패스워드</td>
					<td><input type="password" name="password" maxlength="15">
					</td>
				</tr>

				<tr>
					<td id="title">가입일자</td>
					<td><input type="text" name="date" maxlength="15">
					</td>
				</tr>
				
			</table>
			<br> <input type="submit" value="등 록" /> <input type="button" value="취 소">
		</form>
	</div>
</body>
</html>