<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.google.gson.Gson"%>
<% 
	List<Map<String,Object>> nList = (List)request.getAttribute("nList");
	Gson g = new Gson();
	String temp = g.toJson(nList);
	out.print(temp);
%>