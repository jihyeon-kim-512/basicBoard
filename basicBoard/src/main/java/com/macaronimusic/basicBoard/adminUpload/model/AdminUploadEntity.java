package com.macaronimusic.basicBoard.adminUpload.model;

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

}
