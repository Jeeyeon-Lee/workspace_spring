<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a2.jsp</title>
</head>
<body>
	<h2>a2.jsp페이지</h2>
	<p>내용1</p>
	<p>내용2</p>
<%
  //스크립틀릿 : 이동해보자
  //2번예제 : forward 
	RequestDispatcher view = request.getRequestDispatcher("./b2.jsp");
	view.forward(request, response);  
%>
	<p>여기코드는 실행될까??(이동처리 후에)</p>
</body>
</html>