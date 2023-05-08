package com.myweb.board.model;

import java.time.LocalDateTime;

public class BoardVO {

	
	private int boardIDd;
	private String writer;
	private String title;
	private String content;
	private LocalDateTime regDate;
	private int hit;
	
	public BoardVO() {
		
	}
	

	public BoardVO(int boardIDd, String writer, String title, String content, LocalDateTime regDate, int hit) {
		super();
		this.boardIDd = boardIDd;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
	}


	public int getBoardIDd() {
		return boardIDd;
	}

	public void setBoardIDd(int boardIDd) {
		this.boardIDd = boardIDd;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "BoardVO [boardIDd=" + boardIDd + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", hit=" + hit + "]";
	}
	
	
}
