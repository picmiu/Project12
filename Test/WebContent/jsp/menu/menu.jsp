<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
   <meta charset="UTF-8">
   <title>menu.jsp</title>
</head>

<body>
   <div align="center">
      <div>
         <h1> 회 원 관 리 </h1></br>
      </div>
      <div id="nav">
         	 <li> <a href="/Test/Join.do"> 회 원 가 입 </a>
             </li>
            <c:if test="${id eq null || auth eq null }">
              <li> <a href="/Test/jsp/member/login.jsp">로 그 인</a></li>
            </c:if>
            <c:if test="${id ne null && auth ne null}">
              <li> <a href="/Test/Logout.do">로그아웃 </a></li>
            </c:if>
      </div>
   </div>
</body>

</html>