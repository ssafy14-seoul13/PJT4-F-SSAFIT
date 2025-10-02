package com.pjt4.ssafit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pjt4.ssafit.dto.User.Review;
import com.pjt4.ssafit.util.DBUtil;

public class ReviewRepositoryImpl implements ReviewRepository {

	// DB연결
	private DBUtil util = DBUtil.getInstance();

	///////////////////////////////////////////////////////// 싱글턴
	private static ReviewRepository repo = new ReviewRepositoryImpl();

	private ReviewRepositoryImpl() {

	}

	public static ReviewRepository getInstance() {
		return repo;
	}

	//////////////////////////////////////////////////////////////
	@Override
	public List<Review> selectAll() {
		List<Review> list = new ArrayList<>();
		String sql = "SELECT * FROM review ORDER BY id DESC";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Review review = new Review();
				review.setId(rs.getInt("id"));
				review.setWriter(rs.getString("writer"));
				review.setTitle(rs.getString("title"));
				review.setContent(rs.getString("content"));
				review.setViewCnt(rs.getInt("view_cnt"));
				review.setRegDate(rs.getString("reg_date"));
				review.setVideoId(rs.getInt("video_id"));
				list.add(review);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, stmt, conn);
		}
		return list;
	}

	@Override
	public Review selectOneById(int id) {
		Review review = null;
		String sql = "SELECT * FROM review WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				review = new Review();
				review.setId(rs.getInt("id"));
				review.setWriter(rs.getString("writer"));
				review.setTitle(rs.getString("title"));
				review.setContent(rs.getString("content"));
				review.setViewCnt(rs.getInt("view_cnt"));
				review.setRegDate(rs.getString("reg_date"));
				review.setVideoId(rs.getInt("video_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}

		return review;
	}

	@Override
	public List<Review> selectByTitle(String keyword) {
		List<Review> list = new ArrayList<>();
		String sql = "SELECT * FROM review WHERE title LIKE ? ORDER BY id DESC";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Review review = new Review();
				review.setId(rs.getInt("id"));
				review.setWriter(rs.getString("writer"));
				review.setTitle(rs.getString("title"));
				review.setContent(rs.getString("content"));
				review.setViewCnt(rs.getInt("view_cnt"));
				review.setRegDate(rs.getString("reg_date"));
				review.setVideoId(rs.getInt("video_id"));
				list.add(review);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}

		return list;
	}

	@Override
	public void insertReview(Review review) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO review (title, writer, content) VALUES(?,?,?)";

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getTitle());
			pstmt.setString(2, review.getWriter());
			pstmt.setString(3, review.getContent());

			int result = pstmt.executeUpdate();
			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void updateReview(Review review) {
		String sql = "UPDATE review SET title = ?, content = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getTitle());
			pstmt.setString(2, review.getContent());
			pstmt.setInt(3, review.getId());

			int result = pstmt.executeUpdate();
			System.out.println("Update result: " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void deleteReview(int id) {
		String sql = "DELETE FROM review WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			int result = pstmt.executeUpdate();
			System.out.println("Delete result: " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void updateViewCnt(int id) {
		String sql = "UPDATE review SET view_cnt = view_cnt + 1 WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			int result = pstmt.executeUpdate();
			System.out.println("ViewCnt update result: " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}
}
