<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 페이지</h1>
<form action="member">
	<input type="text" name="loginId" placeholder="아이디">
	<br>	
	<input type="password" name="loginPw" placeholder="비밀번호">
	<br>
	<input type="submit" value="로그인">
	<input type="hidden" name="action" value="doLogin"><br>
	
	
</body>
</form>
</html>
