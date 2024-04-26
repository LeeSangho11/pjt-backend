package com.pjt.backend.dto.response.board;

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
public class ResBoardWriteDto {

	private Long boardId;
	private String title;
	private String subject;
	private String content;
	private String delete_Yn;
	private String createdDate;
	
	@Builder
	public ResBoardWriteDto(Long boardId, String title, String subject, String content, String delete_Yn,
			String createdDate) {
		
		this.boardId= boardId;
		this.title = title;
		this.subject = subject;
		this.content = content;
		this.delete_Yn = delete_Yn;
		this.createdDate = createdDate;
	} 
	
	public static ResBoardWriteDto fromEntity(Board board) {
		return ResBoardWriteDto.builder()
				.boardId(board.getBoardId())
				.title(board.getTitle())
				.subject(board.getSubject())
				.content(board.getContent())
				.delete_Yn(board.getDelete_Yn())
				.createdDate(board.getCreatedDate())
				.build();
	}
	
}
