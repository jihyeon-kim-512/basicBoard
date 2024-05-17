package com.macaronimusic.basicBoard.adminUpload.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.macaronimusic.basicBoard.adminUpload.dto.AdminUploadDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "mm_admin_upload")
public class AdminUploadEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String title;
	@Column
	private String artist;
	@Column
	private String vocal;	
	@Column
	private String featuring;	
	@Column
	private String composer;
	@Column
	private String lyricist;
	@Column
	private String arranger;
	@Column
	private String album;
	@Column
	private String playtime;
	@Column
	private String file_name;
	@CreationTimestamp
	@Column
	private LocalDateTime upload_date;
	
    public static AdminUploadEntity toAdminUploadEntity(AdminUploadDTO adminUploadDTO){
    	AdminUploadEntity adminUploadEntity = new AdminUploadEntity();
    	adminUploadEntity.setId(adminUploadDTO.getId());
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
