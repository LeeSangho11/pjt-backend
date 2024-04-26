package com.pjt.backend.entity;

import com.pjt.backend.common.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(name = "board_seq_generate",sequenceName = "board_seq", allocationSize = 1)
public class Board extends BaseTimeEntity{

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_generate")
	@Column(name="BOARD_ID")
	private Long boardId;
	
	@Column(name="SUBJECT")
	private String subject;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="DELETE_YN")
	private String delete_Yn;

	@PrePersist
	public void prePersist() {
		this.delete_Yn = this.delete_Yn == null ? "N" : this.delete_Yn;
	}
	
	@Builder
	public Board(Long boardId, String subject, String title, String content, String delete_Yn) {
		this.boardId = boardId;
		this.subject = subject;
		this.title = title;
		this.content = content;
		this.delete_Yn = delete_Yn;
	}
	
	// ¼öÁ¤ dirty check
	public void update(String subject, String title, String content) {
		this.subject = subject;
		this.title = title;
		this.content = content;
	}
}
