<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, java.io.PrintWriter, com.google.gson.Gson" %>

<%
List<Map<String, Object>> list = new ArrayList<>();
Map<String, Object> rmap = new HashMap<>();
rmap.put("deptno",10);
rmap.put("dname","총무부");
rmap.put("loc","서울");
list.add(rmap);
rmap.put("deptno",20);
rmap.put("dname","개발부");
rmap.put("loc","인천");
list.add(rmap);
rmap.put("deptno",30);
rmap.put("dname","운영부");
rmap.put("loc","경기");
list.add(rmap);
Gson g = new Gson();
String temp = g.toJson(list); 
out.print(temp);
%>
