package com.macaronimusic.basicBoard.crawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macaronimusic.basicBoard.crawler.model.NewsongEntity;

public interface NewsongRepository extends JpaRepository<NewsongEntity, Long> {

}
