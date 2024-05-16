package com.macaronimusic.basicBoard.adminUpload.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExcelData {

	private String title;

	private String artist;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
}