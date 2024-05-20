package com.macaronimusic.basicBoard.adminUpload.dto;

import com.macaronimusic.basicBoard.adminUpload.model.AdminUploadEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AdminUploadDTO {

	private Long id;
	private String title;
	private String artist;
	private String vocal;
	private String Featuring;
	private String composer;
	private String lyricist;
	private String arranger;
	private String album;
	private String playtime;
	private String file_name;

	public static AdminUploadEntity toAdminUploadEntity(AdminUploadDTO adminUploadDTO) {
		AdminUploadEntity adminUploadEntity = new AdminUploadEntity();
		adminUploadEntity.setTitle(adminUploadDTO.getTitle());
		adminUploadEntity.setArtist(adminUploadDTO.getArtist());
		adminUploadEntity.setVocal(adminUploadDTO.getVocal());
		adminUploadEntity.setFeaturing(adminUploadDTO.getFeaturing());
		adminUploadEntity.setComposer(adminUploadDTO.getComposer());
		adminUploadEntity.setLyricist(adminUploadDTO.getLyricist());
		adminUploadEntity.setArranger(adminUploadDTO.getArranger());
		adminUploadEntity.setAlbum(adminUploadDTO.getAlbum());
		adminUploadEntity.setPlaytime(adminUploadDTO.getPlaytime());
		adminUploadEntity.setFile_name(adminUploadDTO.getFile_name());

		return adminUploadEntity;
	}

}