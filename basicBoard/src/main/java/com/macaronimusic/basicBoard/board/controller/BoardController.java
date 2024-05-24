package com.macaronimusic.basicBoard.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	@GetMapping("/general")
	public String generalBoard(Model model) {
		return "general";
	}
}
