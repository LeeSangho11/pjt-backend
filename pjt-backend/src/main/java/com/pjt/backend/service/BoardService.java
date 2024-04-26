package com.pjt.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pjt.backend.dto.request.board.ReqBoardUpdateDto;
import com.pjt.backend.dto.request.board.ReqBoardWriteDto;
import com.pjt.backend.dto.response.board.ResBoardDetailDto;
import com.pjt.backend.dto.response.board.ResBoardListDto;
import com.pjt.backend.dto.response.board.ResBoardWriteDto;
import com.pjt.backend.entity.Board;
import com.pjt.backend.repositiory.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;
	
	@Transactional(readOnly = true)
	public List<ResBoardListDto> getBoardList(){
		
		List<Board> findList = boardRepository.findAll();
		List<ResBoardListDto> list = findList.stream().map(ResBoardListDto::fromEntity).collect(Collectors.toList());
		
	
		return list;
	}
	
	@Transactional
	public ResBoardWriteDto write(ReqBoardWriteDto reqBoardWriteDto) {
		
		Board board = ReqBoardWriteDto.ofEntity(reqBoardWriteDto);
		Board saveBoard = boardRepository.save(board);
		
		return ResBoardWriteDto.fromEntity(saveBoard);
	}
	
	@Transactional
	public ResBoardDetailDto detail(Long boardId) {
		
		Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("no such data"));
		
		return ResBoardDetailDto.fromEntity(board);
	}
	
	@Transactional
	public ResBoardDetailDto update(Long boardId, ReqBoardUpdateDto reqBoardUpdateDto) {
		
		Board updateBoard = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("no such data"));
		updateBoard.update(reqBoardUpdateDto.getSubject(), reqBoardUpdateDto.getTitle(), reqBoardUpdateDto.getContent());
		
		return ResBoardDetailDto.fromEntity(updateBoard);
	}
	
	@Transactional
    public void delete(Long boardId) {
        boardRepository.deleteById(boardId);
    }
	
}
