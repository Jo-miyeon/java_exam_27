<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="board.article.ArticleDao"%>
<%@ page import="board.article.Article"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:if test="${loginedMember != null}">${loginedMember.nickname}님 반갑습니다!</c:if>
<!--request에 없을때 자동적으로 session찾음 그래도 없으면 application -->
<c:if test="${loginedMember == null}">
	<a href="/web-exam1/member?action=showLogin">로그인</a>
	<a href="/web-exam1/member?action=showMember">회원가입</a>
</c:if>
<body>
	<h1>게시물목록</h1>
	<%
	int num = 10; //request저장소에 저장x page저장소
	Article a = new Article();
	a.getId();
	a.getTitle();
	request.setAttribute("num", 10);
	request.setAttribute("a", a);//el표현을 쓸때는 반드시 request에 저장하고 써야함.
	ArrayList<Article> articles = (ArrayList<Article>) request.getAttribute("myData");
	%>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<!-- el표 -->
		<c:forEach var="article" items="${myData}">
			<!-- mydata랑 연결되어있는 articles가 꺼내져 
		mydata에 있는걸 꺼내서 article이라는 변수에 담음. article은 객체라서 원하는 멤버를 정해줘야-->
			<tr>
				<td>${article.id}</td>
				<td><c:choose>
						<c:when test="${loginedMember == null}">
							<a href="/web-exam1/member?action=showLogin">${article.title}_${article.id}</a>
						</c:when>
						<c:otherwise>
							<a href="/web-exam1/article?action=detail&id=${article.id}">${article.title}_${article.id}</a></td>
				</c:otherwise>
				</c:choose>


				<td>${article.nickname}</td>
				<td>${article.regDate}</td>
				<td>${article.hit}</td>
			</tr>
			<!--${a.id}   articledao에 만든 변수명 그대로 사용하면 됨. -->
		</c:forEach>

	</table>
	<a href="/web-exam1/article?action=showAdd&mid=${loginedMember.id}">글쓰기</a>
	<form action="/web-exam1/article">
		<select name="dateInterval">
			<option value="all">전체기간</option>
			<option value="-1 day">1일</option>
			<option value="-1 week">1주</option>
			<option value="-1 month">1개월</option>
			<option value="-6 month">6개월</option>
			<option value="-1 year">1년</option>
		</select> <select name="sTarget">
			<option value="title&body">제목+내용</option>
			<option value="title">제목만</option>
			<option value="nickname">글작성자</option>
			<option value="rbody">댓글내용</option>
			<option value="rnickname">댓글작성자</option>
		</select> <input type="text" name="keyword" /> <input type="hidden"
			name="action" value="doSearch" /> <input type="submit" value="검색" />
	</form>
</body>
</html>