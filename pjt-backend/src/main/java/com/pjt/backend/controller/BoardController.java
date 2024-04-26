package com.pjt.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjt.backend.dto.request.board.ReqBoardUpdateDto;
import com.pjt.backend.dto.request.board.ReqBoardWriteDto;
import com.pjt.backend.dto.response.board.ResBoardDetailDto;
import com.pjt.backend.dto.response.board.ResBoardListDto;
import com.pjt.backend.dto.response.board.ResBoardWriteDto;
import com.pjt.backend.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {

	private final BoardService boardService;
	
	  @GetMapping("")
	  public ResponseEntity<List<ResBoardListDto>> boardList(){
	    
		  List<ResBoardListDto> list = boardService.getBoardList();
		  return ResponseEntity.status(HttpStatus.OK).body(list);
	    }
	  
	  // 등록
	  @PostMapping("/write")
	  public ResponseEntity<ResBoardWriteDto> write(@RequestBody ReqBoardWriteDto reqBoardWriteDto){
		  
		  ResBoardWriteDto resBoardWriteDto = boardService.write(reqBoardWriteDto);
		  
		  return ResponseEntity.status(HttpStatus.CREATED).body(resBoardWriteDto);
	  }
	  
	  // 상세보기
	  @GetMapping("/{boardId}")
	  public ResponseEntity<ResBoardDetailDto> detail(@PathVariable("boardId")Long boardId){
		  
		  ResBoardDetailDto resBoardBoardDto = boardService.detail(boardId);
		  
		  return ResponseEntity.status(HttpStatus.OK).body(resBoardBoardDto);
	  }
	  
	  // 수정	
	  @PatchMapping("/{boardId}/update")
	  public ResponseEntity<ResBoardDetailDto> update(@PathVariable("boardId")Long boardId, @RequestBody ReqBoardUpdateDto reqBoardUpdateDto){
		  
		  ResBoardDetailDto updateBoardDTO = boardService.update(boardId, reqBoardUpdateDto);
		  
		  return ResponseEntity.status(HttpStatus.OK).body(updateBoardDTO);
	  }
	  
	  // 삭제
	  @DeleteMapping("/{boardId}/delete")
	  public ResponseEntity<Long> delete(@PathVariable("boardId") Long boardId) {
	        boardService.delete(boardId);
	        return ResponseEntity.status(HttpStatus.OK).build();
	  }
	  
}
