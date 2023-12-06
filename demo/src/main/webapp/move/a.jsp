<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
</head>
<body>
	<h2>a.jsp페이지</h2>
	<p>내용1</p>
	<p>내용2</p>
<%
  //스크립틀릿 : 이동해보자
  //1번예제 : redirect 
	 response.sendRedirect("b.jsp");

%>
	<p>여기코드는 실행될까??(이동처리 후에)</p>
</body>
</html>