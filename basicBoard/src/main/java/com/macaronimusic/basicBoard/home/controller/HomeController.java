package com.macaronimusic.basicBoard.home.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.macaronimusic.basicBoard.crawler.model.RankingEntity;
import com.macaronimusic.basicBoard.home.service.HomeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final HomeService homeService;
	
	@GetMapping("/")
	public String home(Model model) {
		// 기존에 있는 entity를 사용하는것이 좋을지? 새로 만드는것이 좋을지?
        List<RankingEntity> rankings = homeService.getAllUploads();
        model.addAttribute("rankings", rankings);
		return "Home";
	}
}
