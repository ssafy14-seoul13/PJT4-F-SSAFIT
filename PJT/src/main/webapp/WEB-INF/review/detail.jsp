<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>���� �󼼺���</title>
</head>
<body>
    <h2>���� ��</h2>

    <c:if test="${not empty review}">
        <p><strong>����:</strong> ${review.title}</p>
        <p><strong>�ۼ���:</strong> ${review.writer}</p>
        <p><strong>�ۼ���:</strong> ${review.regDate}</p>
        <p><strong>��ȸ��:</strong> ${review.viewCnt}</p>
        <p><strong>����:</strong></p>
        <p>${review.content}</p>

        <hr>

        <!-- ����, ���� ��ư -->
        <a href="review?act=updateform&id=${review.id}">����</a> |
        <a href="review?act=delete&id=${review.id}" onclick="return confirm('���� �����Ͻðڽ��ϱ�?');">����</a> |
        <a href="review?act=list">�������</a>
    </c:if>

    <c:if test="${empty review}">
        <p>�������� �ʴ� �����Դϴ�.</p>
        <a href="review?act=list">�������</a>
    </c:if>
</body>
</html>
