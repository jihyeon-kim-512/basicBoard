package com.macaronimusic.basicBoard.adminUpload.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.macaronimusic.basicBoard.adminUpload.dto.ExcelData;

@Controller
public class AdminUploadController {

	@GetMapping("/admin-upload")
	public String adminUpload() {
		return "adminUpload";
	}

	@PostMapping("admin-upload/uploadexcel")
	public String readExcel(@RequestParam("file") MultipartFile file, Model model) throws IOException { // 2

		List<ExcelData> dataList = new ArrayList<>();

		String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3

		if (!extension.equals("xlsx") && !extension.equals("xls")) {
			throw new IOException("엑셀파일만 업로드 해주세요.");
		}

		Workbook workbook = null;

		if (extension.equals("xlsx")) {
			workbook = new XSSFWorkbook(file.getInputStream());
		} else if (extension.equals("xls")) {
			workbook = new HSSFWorkbook(file.getInputStream());
		}

		Sheet worksheet = workbook.getSheetAt(0);

		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) { // 4

			Row row = worksheet.getRow(i);

			ExcelData data = new ExcelData();

			data.setTitle(row.getCell(0).getStringCellValue());
			data.setArtist(row.getCell(1).getStringCellValue());
			
			
			dataList.add(data);
		}

		model.addAttribute("datas", dataList); // 5

		return "excelList";

	}
}
