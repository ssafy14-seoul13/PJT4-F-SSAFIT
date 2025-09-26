package com.pjt4.ssafit.service;

import com.pjt4.ssafit.dto.User.User;

public interface UserService {
		// 전체 게시글 조회
//		public abstract List<Board> getList();
		// 유저 조회
		public abstract User getUser(String userId);

		// 유저 회원가입
		public abstract boolean RegistUser(User user);

		// 유저 정보 수정
		public abstract boolean modifyUser(User user);

		// 유저 삭제
		public abstract boolean removeUser(User user);

		
}
