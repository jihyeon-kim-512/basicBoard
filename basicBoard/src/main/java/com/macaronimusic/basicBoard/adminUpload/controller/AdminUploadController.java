package com.macaronimusic.basicBoard.adminUpload.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
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

import com.macaronimusic.basicBoard.adminUpload.dto.adminUploadDTO;

@Controller
public class AdminUploadController {

	@GetMapping("/admin-upload")
	public String adminUpload() {
		return "adminUpload";
	}

	@PostMapping("admin-upload/uploadexcel")
	public String readExcel(@RequestParam("file") MultipartFile file, Model model) throws IOException {

		List<adminUploadDTO> dataList = new ArrayList<>();

		String extension = FilenameUtils.getExtension(file.getOriginalFilename());

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

		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

			Row row = worksheet.getRow(i);

			adminUploadDTO data = new adminUploadDTO();
			String data_exist = "";

			// 마지막 행 확인
			for (Cell cell : row) {
				data_exist += cell;
			}

			if (data_exist.equals(""))
				break;

			data.setTitle(row.getCell(0).getStringCellValue());
			data.setArtist(row.getCell(1).getStringCellValue());
			data.setVocal(row.getCell(2).getStringCellValue());
			data.setFeaturing(row.getCell(3).getStringCellValue());
			data.setComposer(row.getCell(4).getStringCellValue());
			data.setLyricist(row.getCell(5).getStringCellValue());
			data.setArranger(row.getCell(6).getStringCellValue());
			data.setAlbum(row.getCell(7).getStringCellValue());
			data.setPlaytime(row.getCell(8).getStringCellValue());
			data.setFilename(row.getCell(9).getStringCellValue());

			// row.getCell(0).getCellType() == 3 셀의 데이터 유형이 BLANK임
			if (row.getCell(0).getCellType() == 3 || row.getCell(1).getCellType() == 3
					|| row.getCell(2).getCellType() == 3 || row.getCell(4).getCellType() == 3
					|| row.getCell(5).getCellType() == 3 || row.getCell(7).getCellType() == 3) {
				continue;

			} else {
				dataList.add(data);
			}

		}

		model.addAttribute("datas", dataList);

		return "excelList";

	}
}
