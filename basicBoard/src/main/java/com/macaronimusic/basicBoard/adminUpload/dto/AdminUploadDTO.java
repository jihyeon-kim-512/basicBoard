package com.macaronimusic.basicBoard.adminUpload.dto;

import com.macaronimusic.basicBoard.adminUpload.entity.AdminUploadEntity;

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
	
    public static AdminUploadDTO toAdminUploadDTO(AdminUploadEntity adminUploadEntity){
    	AdminUploadDTO adminUploadDTO = new AdminUploadDTO();
    	adminUploadDTO.setId(adminUploadEntity.getId());
    	adminUploadDTO.setTitle(adminUploadEntity.getTitle());
    	adminUploadDTO.setArtist(adminUploadEntity.getArtist());
    	adminUploadDTO.setVocal(adminUploadEntity.getVocal());
    	adminUploadDTO.setFeaturing(adminUploadEntity.getFeaturing());
    	adminUploadDTO.setComposer(adminUploadEntity.getComposer());
    	adminUploadDTO.setLyricist(adminUploadEntity.getLyricist());
    	adminUploadDTO.setArranger(adminUploadEntity.getArranger());
    	adminUploadDTO.setAlbum(adminUploadEntity.getAlbum());
    	adminUploadDTO.setPlaytime(adminUploadEntity.getPlaytime());
    	adminUploadDTO.setFile_name(adminUploadEntity.getFile_name());
        
        return adminUploadDTO;
    }

}