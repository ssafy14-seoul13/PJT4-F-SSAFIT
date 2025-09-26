<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입 화면</title>
</head>
<body>

	<form action="user" method="POST">
		<input type="hidden" name="act" value="regist">
		<p>아이디 : <input type="text" name="userId"></p>
		<p>비밀번호 : <input type="password" name="userPw"></p>
		<p>이메일 : <input type="email" name="userEmail"></p>
		<p>성별 : <input type="text" name="gender"></p>
		<p>생년월일 : <input type="text" name="birth"></p>
		<button>회원가입</button>
	</form>
	
</body>
</html>