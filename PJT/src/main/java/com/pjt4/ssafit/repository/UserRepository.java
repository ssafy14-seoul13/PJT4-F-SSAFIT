package com.pjt4.ssafit.repository;

import java.util.List;

import com.pjt4.ssafit.dto.User.User;

public interface UserRepository {
	
	public abstract List<User> selectAll();

	//유저 조회하기
	public abstract User selectOne(String userId);

	//유저 등록하기
	public abstract void insertUser(User user);

	//유저 수정하기
	public abstract void updateUser(User user);

	//유저 삭제하기
	public abstract void deleteUser(String userId);


}
