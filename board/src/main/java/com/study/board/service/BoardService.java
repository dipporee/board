package com.study.board.service;

import java.util.List;

import com.study.board.vo.BoardVO;

public interface BoardService {

	//목록 조회
	public List<BoardVO> getList();
	
	//글 조회
	public BoardVO getContent(int boardId);

	//글쓰기
	public void contentWrite(BoardVO boardVO);

	//최신 글번호
	public int boardId();

	//글 수정
	public void contentModify(BoardVO boardVO);

	//글 삭제
	public void contentDelete(int boardId);

}
