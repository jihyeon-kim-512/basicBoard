package com.macaronimusic.basicBoard.home.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.macaronimusic.basicBoard.crawler.model.RankingEntity;
import com.macaronimusic.basicBoard.home.repository.HomeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeService {

	private final HomeRepository homeRepository;
	
	public List<RankingEntity> getAllUploads() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:00:00");
		String now_time = now.format(formatter);
		return homeRepository.findByrankTimeOrderByRankingAsc(now_time);
	}
}
