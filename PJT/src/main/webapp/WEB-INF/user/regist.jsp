<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ ȭ��</title>
</head>
<body>

	<form action="user" method="POST">
		<input type="hidden" name="act" value="regist">
		<p>���̵� : <input type="text" name="userId"></p>
		<p>��й�ȣ : <input type="password" name="userPw"></p>
		<p>�̸��� : <input type="email" name="userEmail"></p>
		<p>���� : <input type="text" name="gender"></p>
		<p>������� : <input type="text" name="birth"></p>
		<button>ȸ������</button>
	</form>
	
</body>
</html>