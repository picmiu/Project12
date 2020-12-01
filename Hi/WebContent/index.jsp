<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function valiDate() {
		if(document.frm.chked == "N") {
			alert("아이디 중복 확인 체크하세요.")	//중복 체크가 확인되면 form이 전송.
			return false;
		} 
		return true;
	}
	
	function idChk() {
		var f = document.frm.mid.value;
		window.open("Idcheck.do?id="+ id, "childform", "width=400 height=100, resizable = no, scrollbars = no");
	}
</script>
</head>
<body>
<div align="center">
	<form id="frm" name="frm" onsubmit="return valiDate()" action="#" method="post">
		아이디 : <input type="text" id="mid" name="mid" required="required">&nbsp;&nbsp;
		<input type="hidden" id="chked" name="chked" value="N">
		<button type="button" onclick="idChk();">중복 확인</button> <p>
		패스워드 : <input type="password" id="password" name="password" required="required">&nbsp;&nbsp;
		<input type="hidden" id="chked" name="chked" value="N"> <p>
		<input type="submit" value="가입하기">
	</form>
</div>
</body>
</html>