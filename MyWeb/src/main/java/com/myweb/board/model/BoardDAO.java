package com.myweb.board.model;

import java.util.List;

import javax.naming.InitialContext;
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
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
		
	}

	@Override
	public void regist(String wirter, String title, String content) {
		int check = 0;

	}

	@Override
	public List<BoardVO> listBoard() {
		
		return null;
	}

	@Override
	public BoardVO contentBoard(int bId) {
		BoardVO board = null;
		String sql = "";
		return null;
	}

	@Override
	public void updateBoard(String title, String content, int bId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(int bId) {
		// TODO Auto-generated method stub

	}

}
