<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>input Test</h1>
<!-- text: 입력창 
	checkbox: 체크박스 
	hidden: 숨겨진 값 
	submit: 서버에 전송하는 버튼 -->
	<form action="TestController">
		<input type="text" name="text" placeholder="텍스트를 입력해주세요">
		<!-- select : 목록박스  -->
		<select name = "select">
			<option value="1">선택지1</option>
			<option value="2">선택지2</option>
			<option value="3">선택지3</option>
		</select>
		<input type="checkbox" name="checkbox" value="true">
		<input type="hidden" name="action" value="doTest">
		<input type="submit" value="보내기">
	</form>
</body>
</html>