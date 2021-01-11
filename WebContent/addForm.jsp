<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시물 등록</h1>
	<!--QueryString?뒤에 서버에다가 데이터를 넘기는 값을 queryString이라 부른다. -->
	<a href="http://localhost:8080/article?action=insert&title=aa&body=bb&mid=1">등록</a>
	<form action="article">
	<!-- form에 서버정보를 알려줘야 queryString을 만들어서 붙어준다.	form태그는 url제조기-->
		제목: <input type="text" name="title"> 
		<!-- 데이터를 입력할수있는 포멧제공 다양한게 있음 ex)텍스트창 체크박스 등등 -->
		<br>
		내용: <input type="text" name="body">
		<br>
		<input type="hidden" name="mid" value="1">
		<input type="hidden" name="action" value="insert">
		<input type="submit"/> <!-- 버튼  -->
	</form>
</body>
</html>