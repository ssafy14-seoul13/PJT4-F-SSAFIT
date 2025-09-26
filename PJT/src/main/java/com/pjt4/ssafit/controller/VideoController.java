package com.pjt4.ssafit.controller;

import java.io.IOException;
import java.util.List;

import com.pjt4.ssafit.dto.User.Video;
import com.pjt4.ssafit.service.VideoService;
import com.pjt4.ssafit.service.VideoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/video")
public class VideoController extends HttpServlet{
	
	private VideoService videoService = VideoServiceImpl.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		
		switch (act) {
			case "videoForm":
	            request.getRequestDispatcher("/WEB-INF/video/view.jsp").forward(request, response);
	            break;
			case "search":
				doSearch(request, response);
				break;
			case "detail":  
				doDetail(request, response);
				break;
			case "view":
				doView(request, response);
				break;
			case "regist":
				doRegist(request, response);
				break;
	
		}
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String part = request.getParameter("part");
		String url = request.getParameter("url");
		
		Video video = new Video(title, part, url);
		
		if(!videoService.RegistVideo(video)) {
			request.setAttribute("errMsg", "이미 등록된 영상입니다.");
		}
		
		doView(request, response);
	}

	private void doSearch(HttpServletRequest request, HttpServletResponse response) {
		
		String keyword = request.getParameter("search");
		
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Video video = videoService.getVideo(id);
		
		request.setAttribute("video", video);
		
		request.getRequestDispatcher("/WEB-INF/video/detail.jsp").forward(request, response);
		
	}
	
	private void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Video> videoList = videoService.getList();
		
		request.setAttribute("videoList", videoList);
		request.getRequestDispatcher("/WEB-INF/video/view.jsp").forward(request, response);

	}

}
