package com.pjt.backend.dto.response.board;

import com.pjt.backend.entity.Board;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class ResBoardListDto {

	private Long boardId;
	private String subject;
	private String title;
	private String content;
	private String createDate;
	private String modifiedDate;

	@Builder
	public ResBoardListDto(Long boardId, String subject, String title, String content, String createDate,
			String modifiedDate) {
		
		this.boardId= boardId;
		this.subject = subject;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}
	
	public static ResBoardListDto fromEntity(Board board) {
		return ResBoardListDto.builder()
				.boardId(board.getBoardId())
				.subject(board.getSubject())
				.title(board.getTitle())
				.content(board.getContent())
				.createDate(board.getCreatedDate())
				.modifiedDate(board.getModifiedDate())
				.build();
	}
}
