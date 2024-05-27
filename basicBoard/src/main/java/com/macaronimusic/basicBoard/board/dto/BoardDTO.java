package com.macaronimusic.basicBoard.board.dto;

import java.time.LocalDateTime;

import com.macaronimusic.basicBoard.board.model.BoardEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BoardDTO {
	private Long id;
	private String title;
	private String writer;
	private String content;
	
	public static BoardEntity toBoardEntity(BoardDTO boardDTO) {
		BoardEntity boardEntity = new BoardEntity();
		boardEntity.setId(boardDTO.getId());
		boardEntity.setTitle(boardDTO.getTitle());
		boardEntity.setWriter(boardDTO.getWriter());
		boardEntity.setContent(boardDTO.getContent());
		
		return boardEntity;
	}
}
