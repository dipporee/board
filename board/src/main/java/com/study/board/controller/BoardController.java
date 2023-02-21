package com.study.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.study.board.service.BoardService;
import com.study.board.vo.BoardVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//목록 조회
    @GetMapping("/list")
    public String list(Model model) {
		log.info("BoardController list()");
		log.info("main에 커밋하기");
	    log.info("boardService.getList() : " + boardService.getList());
	    
		model.addAttribute("list", boardService.getList());
	    
		return "list";
    }
    
	//글 조회
    @GetMapping("/board/{boardId}")
    public String contentViewForm(Model model, BoardVO boardVO) {
		log.info("BoardController contentViewForm() boardVO");
		log.info("boardVO : " + boardVO);
	    
		int boardId = boardVO.getBoardId();
		
		log.info("boardId : " + boardId);
		
		model.addAttribute("content", boardService.getContent(boardId));
	    
		return "contentViewForm";
    }
    
	//글쓰기 페이지
    @GetMapping("/contentWriteForm")
    public String contentWriteForm() {
		log.info("BoardController contentWriteForm()");
	    
		return "contentWriteForm";
    }
    
    //글쓰기
    @PostMapping("/contentWrite")
    public ResponseEntity<String> contentWrite(@RequestBody BoardVO boardVO) {
    	log.info("BoardController contentWrite()");
    	log.info("boardVO : " + boardVO);

		ResponseEntity<String> entity = null;

		try {
			boardService.contentWrite(boardVO);		//글쓰기
			int boardId = boardService.boardId();	//최신 글번호
			String strBoardId = Integer.toString(boardId);
			
			log.info("boardId : " + boardId);
			
			entity = new ResponseEntity<String>(strBoardId, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
         
		return entity;

    } 
    
	//글 수정 페이지
    @GetMapping("/contentModifyForm/{boardId}")
    public String contentModifyForm(Model model, BoardVO boardVO) {
		log.info("BoardController contentModifyForm() boardVO");
		log.info("boardVO : " + boardVO);
	    
		int boardId = boardVO.getBoardId();
		
		log.info("boardId : " + boardId);
		
		model.addAttribute("content", boardService.getContent(boardId));
	    
		return "contentModifyForm";
    }
    
    //글 수정
    @PutMapping("/board/{boardId}")
    public ResponseEntity<String> contentModify(@RequestBody BoardVO boardVO) {
    	log.info("BoardController contentModify()");
    	log.info("boardVO : " + boardVO);

		ResponseEntity<String> entity = null;

		try {
			boardService.contentModify(boardVO);	//글 수정
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
         
		return entity;

    }
    
    //글 수정
    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<String> contentDelete(@RequestBody BoardVO boardVO) {
    	log.info("BoardController contentDelete()");
    	log.info("boardVO : " + boardVO);

		ResponseEntity<String> entity = null;
		int boardId = boardVO.getBoardId();

		try {
			boardService.contentDelete(boardId);	//글 삭제
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
         
		return entity;

    }
}
