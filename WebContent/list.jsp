<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="board.article.ArticleDao" %>
<%@ page import="board.article.Article" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시물목록.</h1>
<%
	//ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("myData");  
%>


<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		
		<c:forEach var="article" items="${myData}"> 
		<!-- mydata랑 연결되어있는 articles가 꺼내져 
		mydata에 있는걸 꺼내서 article이라는 변수에 담음. article은 객체라서 원하는 멤버를 정해줘야-->
		<tr>
			<td>${article.id}</td>
			<td>${article.title}</td>
			<td>${article.nickname}</td>
			<td>${article.regDate}</td>
			<td>${article.hit}</td>
		</tr>
		</c:forEach>
		
	</table>
<a href=http://localhost:8080/web-exam1/TestServlet">링크1</a>
</body>
</html>