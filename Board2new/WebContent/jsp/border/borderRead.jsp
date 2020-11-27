<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>
<script type="text/javascript">
	function formSubmit(str){
		var f = document.frm;
		if(str == "edit") {
			f.action="/Board/BorderSearch.do";
			f.submit();
		} else {
			f.action="/Board/BorderDelete.do";
			f.submit();
		}
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>글 상세 보기</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="100" align="center">작성자</th>
					<td width="100">${vo.borderWriter }</td>
					<th width="100" align="center">작성일자</th>
					<td width="100">${vo.borderDate }</td>
					<th width="100" align="center">조회수</th>
					<td width="100">${vo.borderHit }</td>
				</tr>
				<tr>
					<th width="100" align="center">제목</th>
					<td colspan="5">${vo.borderTitle }</td>
				</tr>
				<th width="100" align="center">내용</th>
				<td colspan="5"><textarea row="7" col="70" readonly>${vo.borderContent }</textarea>
				</td>
			</table>
			<br />
			<div>
				<form id="frm" name="frm" action="/Board/BorderSearch.do" method="post">
					<input type="hidden" id="id" name="id" value="${vo.borderId }">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="submit" onclick="formSubmit('edit')">글 수정</button>&nbsp;&nbsp;&nbsp;
					<button type="submit" onclick="formSubmit('delete')">글 삭제</button>&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='/Board/BorderList.do'">목록 보기</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>