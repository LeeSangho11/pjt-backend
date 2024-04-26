package com.pjt.backend.dto.response.board;

import com.pjt.backend.entity.Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResBoardDetailDto {

	private Long boardId;
	private String subject;
	private String title;
	private String content;
	private String createDate;
	private String modifiedDate;
	
	@Builder
	public ResBoardDetailDto(Long boardId, String subject, String title, String content, String createDate,
			String modifiedDate) {
		
		this.boardId= boardId;
		this.subject = subject;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}
	
	public static ResBoardDetailDto fromEntity(Board board) {
		return ResBoardDetailDto.builder()
				.boardId(board.getBoardId())
				.subject(board.getSubject())
				.title(board.getTitle())
				.content(board.getContent())
				.createDate(board.getCreatedDate())
				.modifiedDate(board.getModifiedDate())
				.build();
	}

}
