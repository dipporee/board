package com.study.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
		private int boardId;
		private String title;
		private String text;
		private Date boardDate;
		private int hit;
		private String memberId;

	}
