package com.macaronimusic.basicBoard.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.macaronimusic.basicBoard.board.dto.BoardDTO;
import com.macaronimusic.basicBoard.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/board/*")
public class BoardController {
	
	private final BoardService boardService;

	@GetMapping("/")
	public String boardList() {
		return "BoardList";
	}
	
	@GetMapping("/general")
	public String board() {
		return "GeneralBoard";
	}
	
	@PostMapping("/general")
	public String write(BoardDTO boardDTO) {
		boardService.save(boardDTO);
		return "redirect:/board/";
	}
	
}
