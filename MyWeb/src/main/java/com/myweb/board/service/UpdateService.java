package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;
import com.myweb.board.model.IBoradDAO;

public class UpdateService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bId = Integer.parseInt(request.getParameter("bId"));
		String title = request.getParameter("bTitle");
		String content = request.getParameter("bContent");
		BoardDAO.getInstance().updateBoard(title, content, bId);
//		//BoardVO vo = dao.updateBoard(bId);
//		
//		request.setAttribute(bId, title, content);

	}

}
