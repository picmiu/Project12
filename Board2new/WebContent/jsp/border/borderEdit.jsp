<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 수정</title>
</head>
<body>
	<div align="center"> <p><h1>글 수 정</h1></p> </div>
	<div align="center">
		<form id="frm" name="frm" action="/Board/BorderInput.do" method="post">
			<table border="1">
				<tr>
					<th width="100">작 성 자</th>
					<td width="300">${vo.borderWriter }</td>
					<th width="100">작 성 일</th>
					<td width="300"><input type="date" id="wdate" name="wdate">${vo.borderDate }</td>
					<th width="100">제 목</th>
					<td width="300">${vo.borderTitle }</td>
					<th width="100">내 용</th>
					<td width="300"><textarea id="content" name="content" row="5" cols="100">
						${vo.borderContent }</textarea></td>
				</tr>
			</table>
		<br />
		<input type="hidden" id="id" name="id" value="${vo.borderId }">
		<button type="button" onclick="location.href='Board/BorderList.do'">목록으로</button>&nbsp;&nbsp;&nbsp;
		<button type="submit">수 정 하 기</button>&nbsp;&nbsp;&nbsp;
		<button type="reset">취 소 하 기</button>&nbsp;&nbsp;&nbsp;
			</form>
		</div>
	</div>
</body>
</html>