<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	일반jsp
	for(int i=0;i<strList.size();i++){
		String str = strList.get(i);
		out.println(str);
	}

	향상된 jsp
	for(String str:strList){
		out.pritnln(str);
	} 
-->
	<c:forEach var="i" begin="1" end="5">
		<div>안녕</div><br>
	</c:forEach>
	<jsp:useBean id="strList2" class="java.util.ArrayList"/>
	<c:forEach var="str" items=${strList2}>${str}</c:forEach> 
	<!-- 왼쪽: 꺼내서 쓸 변수명 오른쪽 :배열이나 리스트 대신 strList2가 list에 있어야함.-->
</body>
</html>