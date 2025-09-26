<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 화면</title>
</head>
<body>
	
	<form action="user" method="POST">
		<input type="hidden" name="act" value="login">
		<p>아이디 : <input type="text" name="userId"></p>
		<p>비밀번호 : <input type="password" name="userPw"></p>
		<button>로그인</button>
	</form>
	
</body>
</html>