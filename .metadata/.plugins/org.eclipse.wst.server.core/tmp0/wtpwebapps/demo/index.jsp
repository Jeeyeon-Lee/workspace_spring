<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"%>
<%
//위 페이지 부분은 임포트문
//스크립틀릿 안에 선언하면 지변
	List<Map<String, Object>> list = (List)request.getAttribute("list");
	out.print(list);
// 1. localhost:8000/index.jsp -> 값이 null로 출력(HelloServlet을 경유x)
// 2. localhost:8000/hello -> 주소는 hello인데 출력페이지는 index.jsp로 보임(요청이 유지되기 때문에) -> 값 출력
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hello 서블릿
<br>
<div><h1>안녕</h1></div>
</body>
</html>