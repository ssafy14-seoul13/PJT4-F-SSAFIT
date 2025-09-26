package com.pjt4.ssafit.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/video")
public class VideoController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		
		switch (act) {
			case "videoForm":
	            request.getRequestDispatcher("/WEB-INF/user/list.jsp").forward(request, response);
	            break;
			case "detail":  
				doDetail(request, response);
				break;
			case "view":
				doView(request, response);
				break;
	
		}
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) {
		
		int videoId = Integer.parseInt(request.getParameter("videoId"));
		
		
	}
	
	private void doView(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
