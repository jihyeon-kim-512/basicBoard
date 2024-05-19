package com.macaronimusic.basicBoard.crawler.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.macaronimusic.basicBoard.crawler.model.NewsongEntity;
import com.macaronimusic.basicBoard.crawler.repository.NewsongRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsongService {

	private final NewsongRepository newsongRepository;

	public List<NewsongEntity> NewsongCrwal() {

		List<NewsongEntity> dataList = new ArrayList<>();

		String url = "https://www.melon.com/new/index.htm";
		String[] region = { "I", "O" };

		try {

			for (String reg : region) {

				Document doc = Jsoup.connect(url)
						.data("areaFlg", reg)
						.data("orderBy", "")
						.data("po", "pageObj")
						.data("startIndex", "1").get();

				Elements els = doc.select("#frm > div > table > tbody > tr");

				int cnt = 1;

				for (Element el : els) {
					NewsongEntity data = new NewsongEntity();
					data.setTitle(el.select("td:nth-child(5) > div > div > div.ellipsis.rank01 > span > a").text());
					data.setArtist(el.select("td:nth-child(5) > div > div > div.ellipsis.rank02 > span > a").text());
					data.setAlbum(el.select("td:nth-child(6) > div > div > div > a").text());
//					data.setAlbumImg(el.select("td:nth-child(3) > div > a > img").attr("src"));  // 앨범 이미지 저장 방법 정하기
					// URL을 저장해서 출력 || 이미지 저장 후 출력?
					//https://cdnimg.melon.co.kr/cm2/album/images/114/91/275/11491275_20240517120102_500.jpg/melon/resize/120/quality/80/optimize
					data.setRegion(reg);

					dataList.add(data);
					newsongRepository.save(data);

					cnt++;
					if (cnt > 10)
						break;
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataList;
	}

}
