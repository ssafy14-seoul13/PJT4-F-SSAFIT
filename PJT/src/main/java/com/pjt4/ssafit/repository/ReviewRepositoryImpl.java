package com.pjt4.ssafit.repository;

import java.util.ArrayList;
import java.util.List;

import com.pjt4.ssafit.dto.User.Review;

public class ReviewRepositoryImpl implements ReviewRepository {

	private List<Review> list = new ArrayList<>();

	private static ReviewRepository repo = new ReviewRepositoryImpl();

	private ReviewRepositoryImpl() {

	}

	public static ReviewRepository getInstance() {
		return repo;
	}

	@Override
	public List<Review> selectAll() {
		return list;
	}

	@Override
	public Review selectOne(int id) {
		for (Review review : list) {
			if (review.getId() == id)
				return review;
		}
		return null;
	}

	@Override
	public void insertReview(Review review) {
		list.add(review);
	}

	@Override
	public void updateViewCnt(int id) {
		Review review = list.get(id);
		review.setViewCnt(review.getViewCnt() + 1);
	}

	@Override
	public void updateReview(Review review) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == review.getId()) {
				list.set(i, review); 
				return;
			}
		}
	}

	@Override
	public void deleteReview(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				list.remove(i);
				return;
			}
		}

	}

}
