<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ȭ��</title>
</head>
<body>
	
	<form action="user" method="POST">
		<input type="hidden" name="act" value="login">
		<p>���̵� : <input type="text" name="userId"></p>
		<p>��й�ȣ : <input type="password" name="userPw"></p>
		<button>�α���</button>
	</form>
	
</body>
</html>