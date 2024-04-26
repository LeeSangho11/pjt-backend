package com.pjt.backend.dto.request.board;

import com.pjt.backend.entity.Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReqBoardWriteDto {

	private String subject;
	private String title;
	private String content;
	
	public ReqBoardWriteDto(String subject, String title, String content) {
		
		this.subject = subject;
		this.title = title;
		this.content = content;
	}
	
	@Builder
	public static Board ofEntity(ReqBoardWriteDto reqBoardWriteDto) {
		
		return Board.builder()
				.subject(reqBoardWriteDto.subject)
				.title(reqBoardWriteDto.title)
				.content(reqBoardWriteDto.content)
				.build();
	}
	
}
