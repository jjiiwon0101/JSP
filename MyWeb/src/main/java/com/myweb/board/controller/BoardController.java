package com.myweb.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.service.IBoardService;


@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private IBoardService sv; //변수 생성
	
    public BoardController() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}
		
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length()+1, uri.lastIndexOf("."));
		
		System.out.println(uri);
		
		switch (uri) {
		
		
		case "write": 
			System.out.println("글쓰기 페이지로 이동 요청!");
			response.sendRedirect("board/board_write.jsp");
			break;
			
		case "regist":
			System.out.println("글 등록 요청이 들어옴!");
			sv = new RegistService();
	
		
		}
		
		
	}

}
