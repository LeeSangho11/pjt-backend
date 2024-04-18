package com.pjt.backend.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BoardDto {

	private int seq;
	private String subject;
	private String title;
	private String content;
	private char delete_Yn;
	private LocalDateTime reg_date;
}
