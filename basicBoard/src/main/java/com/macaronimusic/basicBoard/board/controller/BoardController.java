package com.macaronimusic.basicBoard.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.macaronimusic.basicBoard.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/board/*")
public class BoardController {
	
	private final BoardService boardService;

	@GetMapping("/")
	public String boardList(Model model) {
		return "BoardList";
	}
	
	@GetMapping("/general")
	public String generalBoard(Model model) {
		return "GeneralBoard";
	}
	
	@PostMapping("/general")
	public String generalPost(Model model) {
		return "redirect:/board/";
	}
	
}
