package com.pjt4.ssafit.service;

import java.util.List;

import com.pjt4.ssafit.dto.User.Video;

public interface VideoService {
	// 전체 게시글 조회
	public abstract List<Video> getList();
	// 유저 조회
	public abstract Video getVideo(int id);

	// 유저 회원가입
	public abstract boolean RegistVideo(Video video);

	// 유저 정보 수정
	public abstract boolean modifyVideo(Video video);

	// 유저 삭제
	public abstract boolean removeVideo(Video video);
}
