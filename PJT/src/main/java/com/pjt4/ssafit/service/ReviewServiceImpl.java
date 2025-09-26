package com.pjt4.ssafit.service;

import java.util.List;

import com.pjt4.ssafit.dto.User.Review;
import com.pjt4.ssafit.repository.ReviewRepository;
import com.pjt4.ssafit.repository.ReviewRepositoryImpl;

public class ReviewServiceImpl implements ReviewService {

	
	private static ReviewService service = new ReviewServiceImpl();
	private ReviewRepository repo = ReviewRepositoryImpl.getInstance();
	
	private ReviewServiceImpl(){
		
	}
	
	public static ReviewService getInstance() {
		return service;
		
	}
	@Override
	public List<Review> getList() {
		return repo.selectAll();
	}

	@Override
	public Review getReview(int id) {
		repo.updateViewCnt(id);
		return repo.selectOne(id);
	}

	@Override
	public void writeReview(Review review) {
		repo.insertReview(review);
	}

	@Override
	public void modifyReview(Review review) {
		repo.updateReview(review);
	}

	@Override
	public void removeReview(int id) {
		repo.deleteReview(id);
	}


}
