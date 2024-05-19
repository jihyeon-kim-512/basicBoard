package com.macaronimusic.basicBoard.crawler.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.macaronimusic.basicBoard.crawler.model.NewsongEntity;
import com.macaronimusic.basicBoard.crawler.model.RankingEntity;
import com.macaronimusic.basicBoard.crawler.service.NewsongService;
import com.macaronimusic.basicBoard.crawler.service.RankingService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // 얘가있어야 final 가능
public class CrawlingController {

	private final RankingService rankingService;
	private final NewsongService newsongService;
//    @Autowired // 이거랑 차이는?
//    private DataRepository dataRepository;

	@GetMapping("/mmRankingCrawler")
	public String RankingCrawling(Model model) {
		List<RankingEntity> dataList = rankingService.RankingCrwal();
		model.addAttribute(dataList);
		return "CrawlingResult";
	}

	@GetMapping("/NewsongCrawler")
	public String NewsongCrawling(Model model) {
		List<NewsongEntity> dataList = newsongService.NewsongCrwal();
		model.addAttribute(dataList);
		return "CrawlingResult";
	}

}
