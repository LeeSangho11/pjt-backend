package com.pjt.backend.repositiory;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt.backend.dto.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> selectBoardList();
}
