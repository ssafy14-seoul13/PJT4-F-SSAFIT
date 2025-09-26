package com.pjt4.ssafit.dto.User;

public class User {
	
	private String userId;
	private String userPw;
	private String userEmail;
	private String gender;
	private String birth;
	
	public User() {
	
	}

	public User(String userId, String userPw, String userEmail, String gender, String birth) {
		this.userId = userId;
		this.userPw = userPw;
		this.userEmail = userEmail;
		this.gender = gender;
		this.birth = birth;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
}
