package com.pjt4.ssafit.repository;

import java.util.List;

import com.pjt4.ssafit.dto.User.Video;

public interface VideoRepository {

	public abstract List<Video> selectAll();

	//영상 조회하기
	public abstract Video selectOne(String id);

	//영상 등록하기
	public abstract void insertVideo(Video video);

	//영상 수정하기
	public abstract void updateVideo(Video video);

	//영상 삭제하기
	public abstract void removeVideo(Video video);

}
