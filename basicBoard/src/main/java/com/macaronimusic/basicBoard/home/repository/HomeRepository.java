package com.macaronimusic.basicBoard.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macaronimusic.basicBoard.crawler.model.RankingEntity;


public interface HomeRepository extends JpaRepository<RankingEntity, Long> {
	List<RankingEntity> findAll();
}
