package com.macaronimusic.basicBoard.crawler.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.macaronimusic.basicBoard.crawler.model.RankingEntity;
import com.macaronimusic.basicBoard.crawler.repository.RankingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankingService {

	private final RankingRepository rankingRepository;

	public List<RankingEntity> RankingCrwal() {

		List<RankingEntity> dataList = new ArrayList<>();

		String url = "https://www.melon.com/chart/index.htm";

		try {
			Document doc = Jsoup.connect(url).get();
			Elements els = doc.select("#lst50");

			int rankCnt = 1;

			for (Element el : els) {

				RankingEntity data = new RankingEntity();
				data.setTitle(el.select("td:nth-child(6) > div > div > div.ellipsis.rank01 > span > a").text());
				data.setArtist(el.select("td:nth-child(6) > div > div > div.ellipsis.rank02 > a").text());
				data.setAlbum(el.select("td:nth-child(7) > div > div > div > a").text());
				data.setRanking(rankCnt);
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:00:00");
				data.setRankTime(now.format(formatter)); // ranking 기준 시간

				dataList.add(data);
				rankingRepository.save(data);

				rankCnt++;
				if (rankCnt > 10)
					break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataList;
	}
}
