package com.pjt4.ssafit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pjt4.ssafit.dto.User.User;
import com.pjt4.ssafit.util.DBUtil;

public class UserRepositoryImpl implements UserRepository{

	private DBUtil util = DBUtil.getInstance();
	
	/////////////////////////////////////// 싱글턴
	private static UserRepository repo = new UserRepositoryImpl();

	private UserRepositoryImpl() {

	}

	public static UserRepository getInstance() {
		return repo;
	}
	////////////////////////////////////////////
	
	@Override
	public List<User> selectAll() {
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM user";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User user = new User();
				
				user.setUserId(rs.getString("user_id"));
				user.setUserPw(rs.getString("user_pw"));
				user.setUserEmail(rs.getString("user_email"));
				user.setGender(rs.getString("gender"));
				user.setBirth(rs.getString("birth"));
				
				userList.add(user);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			util.close(conn, stmt, rs);
		}
		
		return userList;
	}

	@Override
	public User selectOne(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM user WHERE user_id=?";
		User user = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				
				user.setUserId(rs.getString("user_id"));
				user.setUserPw(rs.getString("user_pw"));
				user.setUserEmail(rs.getString("user_email"));
				user.setGender(rs.getString("gender"));
				user.setBirth(rs.getString("birth"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt, rs);
		}
		
		return user;
	}

	@Override
	public void insertUser(User user) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO user VALUES(?,?,?,?,?)";
		
		try {
			conn = util.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getBirth());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "명의 유저가 회원가입 했습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
	}

	@Override
	public void updateUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE user SET user_pw=?, user_email=?, gender=? WHERE user_id=?";
		try {
			conn = util.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getUserPw());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setString(3, user.getGender());
			pstmt.setString(4, user.getUserId());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "명의 유저의 정보가 수정되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
	}

	@Override
	public void removeUser(User user) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELET FROM user WHERE user_id=?";
		
		try {
			conn = util.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "명의 유저가 삭제되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
	}

}
