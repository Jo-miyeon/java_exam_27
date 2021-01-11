<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int a= 10;
	ArrayList<Integer> numList = new ArrayList<>();
	
	for(int i=0;i<10;i++) {
		numList.add(i+1);
	}
%>
<% for(int i=0;i<numList.size();i++) {%>
	<div><%=numList.get(i)%></div>
	<%}%>
</body>
</html>