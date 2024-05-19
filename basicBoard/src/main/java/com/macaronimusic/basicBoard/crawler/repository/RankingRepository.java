package com.macaronimusic.basicBoard.crawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macaronimusic.basicBoard.crawler.model.RankingEntity;

// @Repository 유무 차이는?
@Repository
public interface RankingRepository extends JpaRepository<RankingEntity, Long> {

}
