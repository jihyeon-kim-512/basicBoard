package com.macaronimusic.basicBoard.adminUpload.service;

import org.springframework.stereotype.Service;

import com.macaronimusic.basicBoard.adminUpload.dto.AdminUploadDTO;
import com.macaronimusic.basicBoard.adminUpload.model.AdminUploadEntity;
import com.macaronimusic.basicBoard.adminUpload.repository.AdminUploadRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminUploadService {

	private final AdminUploadRepository adminUploadRepository;

	public void save(AdminUploadDTO adminUploadDTO) {
		AdminUploadEntity adminUploadEntity = AdminUploadEntity.toAdminUploadEntity(adminUploadDTO);
		adminUploadRepository.save(adminUploadEntity);
	}

}
