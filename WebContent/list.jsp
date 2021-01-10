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
	ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("myData");  
%>
<table border="1">
<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>조회수</td>
	</tr>
	<%for(int i=0; i<5; i++){%>
		<tr>
			<td>1</td>
			<td>게시물1</td>
			<td>홍길동</td>
			<td>20201216</td>
		</tr>
	<%}%>
	<% int a=10;
	int b=20;
	out.println(a);
	%><br>
	<%=b %><br>
	<%! public void test() {
		System.out.println("aa");
	}%>
</table>
<a href=http://localhost:8080/web-exam1/TestServlet">링크1</a>
</body>
</html>