package com.macaronimusic.basicBoard.adminUpload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macaronimusic.basicBoard.adminUpload.entity.AdminUploadEntity;

@Repository // 첫번째 인자 : 어떤 Entity인지, 두번째 인자 : pk 어떤 타입인지
public interface AdminUploadRepository extends JpaRepository<AdminUploadEntity, Long> {

}
