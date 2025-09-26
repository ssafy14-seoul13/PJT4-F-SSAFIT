<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFIT 운동 영상 목록</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h1 { color: #333; }
        .video-container { display: flex; flex-wrap: wrap; gap: 20px; }
        .video-card { border: 1px solid #ddd; padding: 15px; width: 300px; box-shadow: 2px 2px 5px rgba(0,0,0,0.1); }
        .video-card h3 { margin-top: 0; }
        .video-card p { margin: 5px 0; }
        .video-card a { text-decoration: none; color: #007bff; }
        .search-form, .recommend-form { margin-bottom: 20px; padding: 10px; border: 1px solid #eee; background-color: #f9f9f9; }
    </style>
</head>
<body>
    <h1>SSAFIT 운동 영상</h1>

    <div class="search-form">
        <form action="video" method="get">
            <input type="hidden" name="act" value="search">
            <input type="text" name="keyword" placeholder="영상 제목 검색">
            <button type="submit">검색</button>
        </form>
    </div>
	
	<div class="regist-form">
		<form action="video" method="post">
			<input type="hidden" name="act" value="regist">
			<p>제목 : <input type="text" name="title"></p>
			<p>부위 : <input type="text" name="part"></p>
			<p>url : <input type="text" name="url"></p>
			<button>등록</button>
			
		</form>
	</div>
	
    <h2>영상 목록</h2>
    <div class="video-container">
        <c:forEach var="video" items="${videoList}">
            <div class="video-card">
                <h3>${video.title}</h3>
                <p><strong>운동 부위:</strong> ${video.part}</p>
                <p><strong>조회수:</strong> ${video.viewCnt}</p>
                <p><a href="${video.url}" target="_blank">영상 보러가기</a></p>
            </div>
        </c:forEach>
        <c:if test="${empty videoList}">
            <p>등록된 영상이 없거나 검색 결과가 없습니다.</p>
        </c:if>
    </div>
</body>
</html>

