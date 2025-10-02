package com.pjt4.ssafit.service;

import java.util.List;

import com.pjt4.ssafit.dto.User.Review;

public interface ReviewService {
	// 전체 게시글 조회
	public abstract List<Review> getList();

	// 게시글 조회 - id
	public abstract Review getReviewById(int id);

	// 게시글 조회 - 제목 keyword
	public abstract List<Review> getReviewByTitle(String keyword);
	
	// 게시글 작성
	public abstract void writeReview(Review review);

	// 게시글 수정
	public abstract void modifyReview(Review review);

	// 게시글 삭제
	public abstract void removeReview(int id);

}
