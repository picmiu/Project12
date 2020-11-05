<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>파일업로드</title>
</head>
<body>
  <form action="../FileUpload" method="post" enctype="multipart/form-data">
  <input type = "file" name = "attach1">
  <input type = "submit" value = "파일업로드">
  </form>
</body>
</html>