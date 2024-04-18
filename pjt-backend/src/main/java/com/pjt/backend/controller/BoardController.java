package com.pjt.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjt.backend.dto.BoardDto;
import com.pjt.backend.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	 private BoardService boardService;

	  @GetMapping("/board")
	  public ResponseEntity<List<BoardDto>> getBoardList(){
		  
	        return ResponseEntity.ok(boardService.selectBoardList());
	    }
}
