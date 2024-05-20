package com.macaronimusic.basicBoard.adminUpload.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.macaronimusic.basicBoard.adminUpload.dto.AdminUploadDTO;
import com.macaronimusic.basicBoard.adminUpload.service.AdminUploadService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminUploadController {

	private final AdminUploadService adminUploadService;

	@GetMapping("/admin-upload")
	public String adminUpload() {
		return "AdminUpload";
	}

	@PostMapping("/admin-upload")
	public String readExcel(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		List<AdminUploadDTO> dataList = adminUploadService.ReadExcel(file);
		model.addAttribute("datas", dataList);
		return "ExcelList";
	}
}
