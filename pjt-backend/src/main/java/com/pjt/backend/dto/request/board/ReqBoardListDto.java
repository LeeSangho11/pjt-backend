package com.pjt.backend.dto.request.board;

import com.pjt.backend.entity.Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqBoardListDto {

	private Long boardId;
	private String subject;
	private String title;
	private String content;
	private String delete_Yn;
	
	@Builder
	public ReqBoardListDto(Long boardId, String subject, String title, String content, String delete_Yn) {

		this.boardId = boardId;
		this.subject = subject;
		this.title = title;
		this.content = content;
		this.delete_Yn = delete_Yn;
	}
	
	public Board ToEntity() {
		return Board.builder()
				.boardId(this.boardId)
				.subject(this.subject)
				.title(this.title)
				.content(this.content)
				.delete_Yn(this.delete_Yn)
				.build();
	}
}
