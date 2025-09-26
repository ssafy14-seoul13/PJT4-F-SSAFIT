package com.pjt4.ssafit.service;

import com.pjt4.ssafit.dto.User.User;
import com.pjt4.ssafit.repository.UserRepository;
import com.pjt4.ssafit.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

	// 의존성 주입
	private static UserRepository userRepo = UserRepositoryImpl.getInstance();
	
	private static UserService userService = new UserServiceImpl();
	
	private UserServiceImpl() {
		
	}
	
	public static UserService getInstance() {
		return userService;
	}
	
	@Override
	public User getUser(String userId) {
		
		return userRepo.selectOne(userId);
	}

	@Override
	public boolean RegistUser(User user) {
		
		if(userRepo.selectOne(user.getUserId()) == null) {
			userRepo.insertUser(user);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean modifyUser(User user) {
		if(userRepo.selectOne(user.getUserId()) != null) {
			userRepo.updateUser(user);
			return true;
		}else {
			return false;
		}
		
		
	}

	@Override
	public boolean removeUser(User user) {
		
		if(userRepo.selectOne(user.getUserId()) == null) {
			userRepo.removeUser(user);
			return true;
		}else {
			return false;
		}
		
	}

}
