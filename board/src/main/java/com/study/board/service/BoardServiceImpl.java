package com.study.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.board.mapper.BoardMapper;
import com.study.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	//목록 조회
	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	//글 조회
	@Override
	public BoardVO getContent(int boardId) {
		return mapper.getContent(boardId);
	}

	//글쓰기
	@Override
	public void contentWrite(BoardVO boardVO) {
		mapper.contentWrite(boardVO);
	}

	//최신 글번호
	@Override
	public int boardId() {
		return mapper.boardId();
	}

	//글 수정
	@Override
	public void contentModify(BoardVO boardVO) {
		mapper.contentModify(boardVO);
	}

	//글 삭제
	@Override
	public void contentDelete(int boardId) {
		mapper.contentDelete(boardId);
		
	}

}
