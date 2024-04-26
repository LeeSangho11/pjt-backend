package com.pjt.backend.dto.request.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqBoardUpdateDto {

	private String subject;
	private String title;
	private String content;
	
	@Builder
	public ReqBoardUpdateDto(String subject, String title, String content) {
		this.subject = subject;
		this.title = title;
		this.content = content;
	}
}
