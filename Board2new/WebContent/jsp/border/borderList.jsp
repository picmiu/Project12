<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>borderList.jsp</title>
<style>
tr:hover {background-color:#ffff00;}
</style>
</head>
<body>
<div align="center">
		<div><h1>게 시 판</h1></div>
		<div>
				<table border="1">
					<tr>
						<th width="100">번 호</th>
						<th width="100">제 목</th>
						<th width="100">작 성 자</th>
						<th width="100">작 성 일</th>
						<th width="100">조 회 수</th>
					</tr>
				<c:forEach var="vo" items="${list }">	<!-- list가 객체가 됨 -->
					<tr onclick="location.href='/Board/BorderRead.do?id=${vo.borderId }'">
						<td width="100" align="center"> ${vo.borderId }</td>		<!-- 이 부분에 상세보기가 걸려야 됨 -->
						<td width="250"> ${vo.borderTitle }</td>
						<td width="100" align="center">${vo.borderWriter }</td>
						<td width="100" align="center">${vo.borderDate }</td>
						<td width="100" align="center">${vo.borderHit }</td>
					</tr>
				</c:forEach>				
				</table>
				<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="location.href='jsp/border/borderInput.jsp'">글 쓰 기</button>
		</div>
	</div>
</body>
</html>