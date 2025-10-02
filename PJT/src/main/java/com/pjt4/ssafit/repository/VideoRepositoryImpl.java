package com.pjt4.ssafit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pjt4.ssafit.dto.User.User;
import com.pjt4.ssafit.dto.User.Video;
import com.pjt4.ssafit.service.UserService;
import com.pjt4.ssafit.util.DBUtil;

public class VideoRepositoryImpl implements VideoRepository {
	
	private DBUtil util = DBUtil.getInstance();
	private static VideoRepository videoRepo = new VideoRepositoryImpl();
	
	private VideoRepositoryImpl() {
		
	}
	
	public static VideoRepository getInstance() {
		return videoRepo;
	}
	
	@Override
	public List<Video> selectAll() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Video> videoList = new ArrayList<>();
		String sql = "SELECT * FROM video";
		
		try {
			conn = util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Video video = new Video();
				
				video.setId(rs.getInt("id"));
				video.setTitle(rs.getString("title"));
				video.setPart(rs.getString("part"));
				video.setUrl(rs.getString("url"));
				video.setViewCnt(rs.getInt("view_cnt"));
				
				videoList.add(video);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, stmt, rs);
		}
		
		return videoList;
	}

	@Override
	public Video selectOne(int id) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Video video = null;
		String sql = "SELECT * FROM video WHERE id=?";
		
		try {
			conn = util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				video = new Video();
				
				video.setId(rs.getInt("id"));
				video.setTitle(rs.getString("title"));
				video.setPart(rs.getString("part"));
				video.setUrl(rs.getString("url"));
				video.setViewCnt(rs.getInt("view_cnt"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, stmt, rs);
		}
		
		return video;
	}

	@Override
	public void insertVideo(Video video) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO video VALUES(?,?,?,?,?)";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, video.getId());
			pstmt.setString(2, video.getTitle());
			pstmt.setString(3, video.getPart());
			pstmt.setString(4, video.getUrl());
			pstmt.setInt(5, video.getViewCnt());
			
			int cnt = pstmt.executeUpdate();
			
			System.out.println(video.getId() + "번 영상이 추가되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}

	}

	@Override
	public void updateVideo(Video video) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE video SET title=?, part=?, url=?, view_cnt=0 WHERE id=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, video.getTitle());
			pstmt.setString(2, video.getPart());
			pstmt.setString(3, video.getUrl());
			pstmt.setInt(4, video.getId());
			
			int cnt = pstmt.executeUpdate();
			
			System.out.println(video.getId() + "번 영상이 수정되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
	}

	@Override
	public void removeVideo(Video video) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM video WHERE id=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, video.getId());
			
			int cnt = pstmt.executeUpdate();
			
			System.out.println(video.getId() + "번 영상이 삭제되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}

	}
}
