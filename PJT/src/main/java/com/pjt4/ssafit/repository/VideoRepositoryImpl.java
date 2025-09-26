package com.pjt4.ssafit.repository;

import java.util.ArrayList;
import java.util.List;

import com.pjt4.ssafit.dto.User.User;
import com.pjt4.ssafit.dto.User.Video;
import com.pjt4.ssafit.service.UserService;

public class VideoRepositoryImpl implements VideoRepository {

	List<Video> videoList = new ArrayList<>();
	
	private static VideoRepository videoRepo = new VideoRepositoryImpl();
	
	private VideoRepositoryImpl() {
		
	}
	
	public static VideoRepository getInstance() {
		return videoRepo;
	}
	
	@Override
	public List<Video> selectAll() {
		return videoList;
	}

	@Override
	public Video selectOne(int id) {
		
		for(Video video : videoList) {
			if(videoList.contains(video)) {
				video.setViewCnt(video.getViewCnt() + 1);
				return video;
			}
		}
		
		return null;
	}

	@Override
	public void insertVideo(Video video) {
		
		videoList.add(video);
		
	}

	@Override
	public void updateVideo(Video video) {
		int id = video.getId();
		
		for(Video existVideo : videoList) {
			
			if(existVideo.getId() == id) {
				videoList.remove(existVideo);
				videoList.add(video);
			}
		}
	}

	@Override
	public void removeVideo(Video video) {
		
		videoList.remove(video);
		
	}



}
