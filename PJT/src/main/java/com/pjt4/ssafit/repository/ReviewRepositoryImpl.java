package com.pjt4.ssafit.repository;

import java.util.ArrayList;
import java.util.List;

import com.pjt4.ssafit.dto.User.Review;
import com.pjt4.ssafit.util.DBUtil;

public class ReviewRepositoryImpl implements ReviewRepository {

	private DBUtil util = DBUtil.getInstance();
	
	/////////////////////////////////////// 싱글턴
	private static ReviewRepository repo = new ReviewRepositoryImpl();

	private ReviewRepositoryImpl() {

	}

	public static ReviewRepository getInstance() {
		return repo;
	}
	////////////////////////////////////////////
	
	@Override
	public List<Review> selectAll() {
		return null;
	}

	@Override
	public Review selectOne(int id) {
		return null;
	}

	@Override
	public void insertReview(Review review) {
	}

	@Override
	public void updateViewCnt(int id) {
	}

	@Override
	public void updateReview(Review review) {
	}

	@Override
	public void deleteReview(int id) {

	}

}
