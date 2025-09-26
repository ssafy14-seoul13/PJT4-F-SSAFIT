package com.pjt4.ssafit.service;

import java.util.List;

import com.pjt4.ssafit.dto.User.Video;
import com.pjt4.ssafit.repository.VideoRepository;
import com.pjt4.ssafit.repository.VideoRepositoryImpl;

public class VideoServiceImpl implements VideoService {
	// 의존성 주입
	private static VideoRepository videoRepo = VideoRepositoryImpl.getInstance();
	
	private static VideoService videoService = new VideoServiceImpl();
	
	private VideoServiceImpl() {
		
	}
	
	public static VideoService getInstance() {
		return videoService;
	}
	
	@Override
	public List<Video> getList() {
		return videoRepo.selectAll();
	}

	@Override
	public Video getVideo(int id) {
		
		Video video = videoRepo.selectOne(id);
		
		return video;		
		
	}

	@Override
	public boolean RegistVideo(Video video) {
		
		if(videoRepo.selectOne(video.getId()) == null) {
			videoRepo.insertVideo(video);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean modifyVideo(Video video) {
		
		if(videoRepo.selectOne(video.getId()) != null) {
			videoRepo.updateVideo(video);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean removeVideo(Video video) {
		
		if(videoRepo.selectOne(video.getId()) != null) {
			videoRepo.removeVideo(video);
			return true;
		}
		
		return false;
	}

}
