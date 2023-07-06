package com.study.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private int boardId; // 게시판 아이디
	private String title; // 제목
	private String text; // 내용
	private Date boardDate; // 날짜
	private int hit; // 조회수
	private String memberId; // 아이디

}
