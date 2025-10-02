<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>리뷰 상세보기</title>
</head>
<body>
    <h2>리뷰 상세</h2>

    <c:if test="${not empty review}">
        <p><strong>제목:</strong> ${review.title}</p>
        <p><strong>작성자:</strong> ${review.writer}</p>
        <p><strong>작성일:</strong> ${review.regDate}</p>
        <p><strong>조회수:</strong> ${review.viewCnt}</p>
        <p><strong>내용:</strong></p>
        <p>${review.content}</p>

        <hr>

        <!-- 수정, 삭제 버튼 -->
        <a href="review?act=updateform&id=${review.id}">수정</a> |
        <a href="review?act=delete&id=${review.id}" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a> |
        <a href="review?act=list">목록으로</a>
    </c:if>

    <c:if test="${empty review}">
        <p>존재하지 않는 리뷰입니다.</p>
        <a href="review?act=list">목록으로</a>
    </c:if>
</body>
</html>
