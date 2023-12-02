<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%
//<!-- 스크립틀릿 -->
	List<Map<String, Object>>  list = (List)request.getAttribute("list");
    request.getAttribute("list");
    out.print(list);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title</title>
</head>
<body>
  Hello 서블릿
  <br>
  <div>
    <h1>안녕 서블릿? </h1>
  </div>
</body>
</html>