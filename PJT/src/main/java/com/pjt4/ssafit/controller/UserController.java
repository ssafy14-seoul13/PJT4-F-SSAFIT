package com.pjt4.ssafit.controller;

import java.io.IOException;

import com.pjt4.ssafit.dto.User.User;
import com.pjt4.ssafit.service.UserService;
import com.pjt4.ssafit.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user")
public class UserController extends HttpServlet{

	private UserService userService = UserServiceImpl.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		if (act == null) {
	        // 기본 페이지로 리다이렉트 또는 오류 메시지 표시
	        response.sendRedirect("index.jsp"); 
	        return;
	    }
		
		switch (act) {
			case "loginForm":
	            request.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);
	            break;
	        case "registForm":
	            request.getRequestDispatcher("/WEB-INF/user/regist.jsp").forward(request, response);
	            break;
			case "login":  
				doLogin(request, response);
				break;
			case "regist":
				doRegister(request, response);
				break;
			case "update":
				doUpdate(request, response);
				break;
			case "remove":
				doRemove(request, response);
				break;

		}
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		User user = userService.getUser(userId);
		// 회원가입된 유저의 정보와 입력받은 아이디 비밀번호가 같다면 로그인
		if(user != null && user.getUserId().equals(userId) && user.getUserPw().equals(userPw)) {
			
			// session에 userId 저장
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setMaxInactiveInterval(60 * 10);
			
			// 영상 리스트 화면으로 이동
			request.getRequestDispatcher("/WEB-INF/video/list.jsp").forward(request, response);
		}
	}
	
	private void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userEmail = request.getParameter("userEmail");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");
		
		User foundUser = userService.getUser(userId);
		
		if(foundUser == null) {
			User user = new User(userId, userPw, userEmail, gender, birth);
			userService.RegistUser(user);
			
			System.out.println("회원가입 성공!");
			request.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);
		}else {
			System.out.println("회원가입 실패!");
			request.setAttribute("errMsg", "이미 존재하는 아이디입니다.");
			request.getRequestDispatcher("/WEB-INF/user/regist.jsp").forward(request, response);			
		}
		
	}
	
	
	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userEmail = request.getParameter("userEmail");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");
		
		if(userService.getUser(userId) != null) {
			User user = new User(userId, userPw, userEmail, gender, birth);
			userService.modifyUser(user);
			
			// session에 userId 저장
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setMaxInactiveInterval(60 * 10);
			
			request.getRequestDispatcher("/WEB-INF/user/view.jsp").forward(request, response);
		}else {
			request.setAttribute("errMsg", "이미 존재하지 않는 아이디입니다.");
			request.getRequestDispatcher("/WEB-INF/user/regist.jsp").forward(request, response);			
		}
		
	}
	
	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userEmail = request.getParameter("userEmail");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");
		
		if(userService.getUser(userId) != null) {
			User user = new User(userId, userPw, userEmail, gender, birth);
			userService.removeUser(user);
			
			
			request.getRequestDispatcher("/WEB-INF/user/regist.jsp").forward(request, response);
		}else {
			request.setAttribute("errMsg", "이미 존재하지 않는 아이디입니다.");
			request.getRequestDispatcher("/WEB-INF/user/view.jsp").forward(request, response);			
		}
		
	}

}
