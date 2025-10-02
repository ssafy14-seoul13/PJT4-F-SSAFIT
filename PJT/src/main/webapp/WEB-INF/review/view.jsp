<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFIT 리뷰 게시판</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px;
}

h1 {
	color: #333;
}

/* 검색 폼, 작성 폼 */
.search-form, .write-form {
	margin-bottom: 20px;
	padding: 10px;
	border: 1px solid #eee;
	background-color: #f9f9f9;
	max-width: 600px;
}

.search-form form {
	display: flex;
	gap: 10px;
	align-items: center;
}

.search-form input {
	flex: 1;
	padding: 5px;
}

.search-form button {
	padding: 5px 10px;
}

.write-form input, .write-form textarea, .write-form select {
	width: 100%;
	box-sizing: border-box;
	margin-bottom: 10px;
	padding: 5px;
}

.write-form button {
	padding: 5px 10px;
}

/* 리뷰 카드 영역 */
.review-container {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
}

.review-card {
	border: 1px solid #ddd;
	padding: 15px;
	width: 300px;
	box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1);
}

.review-card h3 {
	margin-top: 0;
}

.review-card p {
	margin: 5px 0;
}

.review-card a {
	text-decoration: none;
	color: #007bff;
}
</style>
</head>
<body>
	<h1>SSAFIT 리뷰 게시판</h1>

	<!-- 검색 기능 -->
	<div class="search-form">
		<form action="review" method="get">
			<input type="hidden" name="act" value="search"> <input
				type="text" name="keyword" placeholder="리뷰 제목 검색">
			<button type="submit">검색</button>
		</form>
	</div>

	<!-- 리뷰 작성 폼 -->
	<div class="write-form">
		<form action="review" method="post">
			<input type="hidden" name="act" value="write">

			<p>
				영상 선택: <select name="videoId" required>
					<c:forEach var="video" items="${videoList}">
						<option value="${video.id}">${video.title}</option>
					</c:forEach>
				</select>
			</p>
			<p>
				제목: <input type="text" name="title" required>
			</p>
			<p>
				작성자: <input type="text" name="writer" required>
			</p>
			<p>
				내용:
				<textarea name="content" rows="4" required></textarea>
			</p>
			<button type="submit">등록</button>
		</form>
	</div>

	<h2>리뷰 목록</h2>
	<div class="review-container">
		<c:forEach var="review" items="${list}">
			<div class="review-card">
				<h3>${review.title}</h3>
				<p>
					<strong>영상:</strong> ${review.videoTitle}
				</p>
				<p>
					<strong>작성자:</strong> ${review.writer}
				</p>
				<p>
					<strong>작성일:</strong> ${review.regDate}
				</p>
				<p>
					<strong>조회수:</strong> ${review.viewCnt}
				</p>
				<p>${review.content}</p>
				<p>
					<a href="review?act=detail&id=${review.id}">자세히 보기</a> | <a
						href="review?act=updateform&id=${review.id}">수정</a> | <a
						href="review?act=delete&id=${review.id}"
						onclick="return confirm('삭제하시겠습니까?')">삭제</a>
				</p>
			</div>
		</c:forEach>

		<c:if test="${empty list}">
			<p>등록된 리뷰가 없습니다.</p>
		</c:if>
	</div>
</body>
</html>
