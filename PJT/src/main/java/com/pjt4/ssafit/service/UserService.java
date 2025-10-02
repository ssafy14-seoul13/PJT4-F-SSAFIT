package com.pjt4.ssafit.service;

import java.util.List;

import com.pjt4.ssafit.dto.User.User;

public interface UserService {
		// 전체 유저 조회
		public abstract List<User> getList();
		// 유저 조회
		public abstract User getUser(String userId);

		// 유저 회원가입
		public abstract boolean RegistUser(User user);

		// 유저 정보 수정
		public abstract boolean modifyUser(User user);

		// 유저 삭제
		public abstract boolean removeUser(User user);

		
}
