package com.macaronimusic.basicBoard.adminUpload.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class adminUploadController {

	@GetMapping("/admin-upload")
	public String adminUpload() {
		return "adminUpload";
	}
	
	@PostMapping("/admin-upload/uploadexcel")
	public String readExcel(@RequestParam("file") MultipartFile file, Model model) {
		//TODO: process POST request
		
		return "excelList";
	}
	
}
