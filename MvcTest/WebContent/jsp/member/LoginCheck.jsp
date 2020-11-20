<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../common/header.jsp" />
<body>
	<div align="center">
		<h1>${param.id }</h1>
		<h1>${param.password }</h1>
		<h3>${msg }</h3>
	</div>
</body>
</html>
<jsp:include page="../common/tail.jsp" />