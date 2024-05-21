package com.macaronimusic.basicBoard.home.service;

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
		return homeRepository.findAll();
	}
}
