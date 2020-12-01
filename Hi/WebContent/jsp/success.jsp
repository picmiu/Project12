<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function formClose() {
		opener.frm.chked.value="Y";
		opener.frm.password.focus();
		window.close();
	}
</script>
</head>
<body>
<div align="center">
	${id }는 사용할 수 있는 ID 입니다.
	<br/>
	<button type="button" onclick="formClose()">확인</button>
</div>
</body>
</html>