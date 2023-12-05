<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.io.PrintWriter, com.google.gson.Gson"%>
    
<% 
	//서버에서 동적 처리된 결과를 받아서 유지해주었기 때문(forwar 메소드로 포워드 되었기 때문에 유지보수됨)
	List<Map<String, Object>> list = (List)request.getAttribute("list");
	Gson g = new Gson();
	String temp = g.toJson(list);
	out.print(temp); //[{"loc":"경기","dname":"운영부","deptno":30}]
%>