package com.pjt4.ssafit.controller;

import java.io.IOException;
import java.util.List;

import com.pjt4.ssafit.dto.User.Review;
import com.pjt4.ssafit.service.ReviewService;
import com.pjt4.ssafit.service.ReviewServiceImpl;

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
		}

	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		request.setAttribute("review", service.getReview(id));
		request.getRequestDispatcher("/WEB-INF/review/detail.jsp").forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Review> list = service.getList();
		request.setAttribute("list", list); 
		request.getRequestDispatcher("/WEB-INF/review/view.jsp").forward(request, response);
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//게시글 객체 생성
		Review review = new Review(title, writer, content);
		
		//게시글 등록
		service.writeReview(review);
		
		//전체 조회
		response.sendRedirect("review?act=list");

	}

	private void doWriteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/review/writeform.jsp").forward(request, response);
	}

}
