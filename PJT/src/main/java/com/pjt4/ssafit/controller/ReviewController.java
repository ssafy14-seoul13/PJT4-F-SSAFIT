package com.pjt4.ssafit.controller;

import java.io.IOException;
import java.util.List;

import com.pjt4.ssafit.dto.User.Review;
import com.pjt4.ssafit.dto.User.Video;
import com.pjt4.ssafit.service.ReviewService;
import com.pjt4.ssafit.service.ReviewServiceImpl;
import com.pjt4.ssafit.service.VideoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/review")
public class ReviewController extends HttpServlet {

	private ReviewService service = ReviewServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");

		switch (act) {
		case "writeform":
			doWriteForm(request, response);
			break;
		case "write":
			doWrite(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "delete":
			doRemove(request, response);
			break;
		case "updateform":
			doUpdateFrom(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		case "search":
            doSearch(request, response); // 제목 검색
            break;
            
		}

	}
	
	// 제목 검색
    private void doSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Review> list = service.getReviewByTitle(keyword);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/WEB-INF/review/view.jsp").forward(request, response);
    }
    
    
	//게시글 수정
	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		Review review = new Review();
		review.setId(id);
		review.setTitle(title);
		review.setWriter(writer);
		review.setContent(content);

		service.modifyReview(review); // 서비스 → 레포지토리에서 update 실행
		response.sendRedirect("review?act=detail&id=" + id); // 수정 후 상세보기로 이동
	}
	//게시글 수정 폼
	private void doUpdateFrom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Review review = service.getReviewById(id); // 기존 글 불러오기
		request.setAttribute("review", review);
		request.getRequestDispatcher("/WEB-INF/review/updateform.jsp").forward(request, response);
	}

	//게시글 삭제
	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		service.removeReview(id); // 서비스 → 레포지토리에서 delete 실행
		response.sendRedirect("review?act=list"); // 삭제 후 목록으로 이동
	}

	// 상세 조회
	private void doDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Review review = service.getReviewById(id);
		request.setAttribute("review", service.getReviewById(id));
		request.getRequestDispatcher("/WEB-INF/review/detail.jsp").forward(request, response);
	}

	// 전체 조회
	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Review> list = service.getList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/review/view.jsp").forward(request, response);
	}

	// 게시글 작성
	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int videoId = Integer.parseInt(request.getParameter("videoId"));

		// 게시글 객체 생성
		Review review = new Review(title, writer, content);
		review.setVideoId(videoId);

		// 게시글 등록
		service.writeReview(review);

		// 전체 조회
		response.sendRedirect("review?act=list");

	}
	
	//게시글 작성 폼
	private void doWriteForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    List<Video> videoList = VideoServiceImpl.getInstance().getList();
	    request.setAttribute("videoList", videoList);
		request.getRequestDispatcher("/WEB-INF/review/writeform.jsp").forward(request, response);
	}

}
