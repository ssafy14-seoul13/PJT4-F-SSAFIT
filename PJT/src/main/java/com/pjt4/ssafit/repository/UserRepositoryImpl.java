package com.pjt4.ssafit.repository;

import java.util.ArrayList;
import java.util.List;

import com.pjt4.ssafit.dto.User.User;

public class UserRepositoryImpl implements UserRepository{

	List<User> userList = new ArrayList<>();
	
	private static UserRepository userRepo = new UserRepositoryImpl();
	
	private UserRepositoryImpl() {
		
	}
	
	public static UserRepository getInstance() {
		return userRepo;
	}
	
	@Override
	public List<User> selectAll() {
		return userList;
	}

	@Override
	public User selectOne(String userId) {
		// 입력받은 userId를 이용중인 유저가 있는지 체크
		for(User user: userList) {
			// 있다면 해당 유저를 리턴
			if(user.getUserId().equals(userId)) return user;
		}
		// 없다면 null을 리턴
		return null;
	}

	@Override
	public void insertUser(User user) {
		// 입력받은 userId를 이용중인 유저가 있는지 체크
		for(User existUser: userList) {
			// 이미 존재하는 유저가 있다면 리턴
			if(existUser.getUserId().equals(user.getUserId())) return;
		}
		
		// 없다면 userList에 추가
		userList.add(user);
	}

	@Override
	public void updateUser(User user) {
		// 입력받은 userId를 이용중인 유저가 있는지 체크
		for(int i = 0; i < userList.size(); i++) {
			// 해당 userId를 이용중인 유저가 있으면 리스트에서 삭제 -> remove(int idx) 메서드를 사용하면 삭제한 User 객체를 반환받음

			if(user.getUserId().equals(userList.get(i).getUserId())) {
				User updateUser = userList.remove(i);
				
				// 삭제한 유저의 정보를 받아서 새로 입력받은 정보를 수정함				
				updateUser.setUserId(user.getUserId());
				updateUser.setUserPw(user.getUserPw());
				updateUser.setUserEmail(user.getUserEmail());
				updateUser.setGender(user.getGender());
				updateUser.setBirth(user.getBirth());
				
				// 수정한 유저 정보를 다시 저장함
				userList.add(updateUser);
			}
		}
		
	}

	@Override
	public void removeUser(User user) {
		// 해당 userId를 삭제
		userList.remove(user);
	}
}
