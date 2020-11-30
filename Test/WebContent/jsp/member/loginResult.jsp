<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
	<c:if test="${auth ne null }">
		<h1>${vo.memberName } 님 로그인 성공</h1>
	</c:if>
	<c:if test ="${auth eq null }">
		<h1>ID ${vo.memberId } 님 로그인 실패</h1>
	</c:if>
</div>
</body>
</html>