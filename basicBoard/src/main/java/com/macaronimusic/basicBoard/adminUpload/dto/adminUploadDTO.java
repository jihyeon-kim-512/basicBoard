package com.macaronimusic.basicBoard.adminUpload.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class adminUploadDTO {

	private String title;
	private String artist;
	private String Vocal;
	private String Featuring;
	private String Composer;
	private String Lyricist;
	private String Arranger;
	private String Album;
	private String Playtime;
	private String Filename;

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

	public String getVocal() {
		return Vocal;
	}

	public void setVocal(String vocal) {
		Vocal = vocal;
	}

	public String getFeaturing() {
		return Featuring;
	}

	public void setFeaturing(String featuring) {
		Featuring = featuring;
	}

	public String getComposer() {
		return Composer;
	}

	public void setComposer(String composer) {
		Composer = composer;
	}

	public String getLyricist() {
		return Lyricist;
	}

	public void setLyricist(String lyricist) {
		Lyricist = lyricist;
	}

	public String getArranger() {
		return Arranger;
	}

	public void setArranger(String arranger) {
		Arranger = arranger;
	}

	public String getAlbum() {
		return Album;
	}

	public void setAlbum(String album) {
		Album = album;
	}

	public String getPlaytime() {
		return Playtime;
	}

	public void setPlaytime(String playtime) {
		Playtime = playtime;
	}

	public String getFilename() {
		return Filename;
	}

	public void setFilename(String filename) {
		Filename = filename;
	}

}