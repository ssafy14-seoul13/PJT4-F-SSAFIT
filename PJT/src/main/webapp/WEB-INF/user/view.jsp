<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFIT 회원 목록</title>
   
</head>
<body>
    <h1>SSAFIT 유저</h1>

    <table>
		<tr>
			<th>유저 아이디</th>
			<th>유저 이메일</th>
			<th>성별</th>
			<th>생년월일</th>
		</tr>
		<c:forEach items="${userList}" var="userList">
			<tr>
				<td>${userList.userId}</td>
				<td>${userList.userEmail}</td>
				<td>${userList.gender}</td>
				<td>${userList.birth}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

