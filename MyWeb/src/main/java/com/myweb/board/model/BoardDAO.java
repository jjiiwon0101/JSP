package com.myweb.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

public class BoardDAO implements IBoradDAO {
	
	private DataSource ds;
	
	private BoardDAO() {
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static BoardDAO dao = new BoardDAO(); //객체 생성
	
	//외부에서 객체 요구시 하나의 객체를 쓰도록 리턴함.
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
		
	}

	@Override
	public void regist(String writer, String title, String content) {
		String sql = "INSERT INTO my_board "
				+ "(board_id, writer, title, content) "
				+ "VALUES(board_seq.NEXTVAL,?,?,?)";
		try 
			(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<BoardVO> listBoard() {
		List<BoardVO> articles = new ArrayList<>();
		String sql = "SELECT * FROM my_board ORDER BY board_id DESC";	
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date").toLocalDateTime(),
						rs.getInt("hit")
						);
				articles.add(vo);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return articles;
	}

	@Override
	public BoardVO contentBoard(int bId) {
		BoardVO vo = null; //변수 선언
		String sql = "SELECT * FROM my_board WHERE board_id=" + bId;
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if(rs.next()) {
				vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date").toLocalDateTime(),
						rs.getInt("hit")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void updateBoard(String title, String content, int bId) {
		String sql = "UPDATE my_board "
				+ "SET title=?, content=? "
				+ "WHERE board_id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bId);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteBoard(int bId) {
		String sql = "DELETE "
				+ "FROM my_board "
				+ "WHERE board_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<BoardVO> searchBoard(String keyword, String category) {
		List<BoardVO> searchList = new ArrayList<>();
		String sql = "SELECT * FROM my_board WHERE " + category + "LIKE ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date").toLocalDateTime(),
						rs.getInt("hit")
						);
				searchList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return searchList;
	}

}
