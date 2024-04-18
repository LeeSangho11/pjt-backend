package com.pjt.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt.backend.dto.BoardDto;
import com.pjt.backend.repositiory.BoardMapper;

@Service
public class BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	public List<BoardDto> selectBoardList() {
		
		List<BoardDto> boardList = boardMapper.selectBoardList();
		
		return boardList;
	}
}
