package com.app.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.file.FileInfo;

public class FileManager {

//	static final String FILE_DIRECTORY_PATH = "d:/fileStorage/";
//	static final String FILE_URL_PATH = "/fileStorage/";
//	
//	public static FileInfo storeFile(MultipartFile file) {
//		
//		//파일 폴더 저장 -> 파일에 대한 정보를 기반 -> DB 저장
//		
//		FileInfo fileInfo = new FileInfo();
//		
//		
//		fileInfo.setOriginalFileName(file.getOriginalFilename());
//		fileInfo.setFilePath(FILE_DIRECTORY_PATH);
//		fileInfo.setUrlFilePath(FILE_URL_PATH);
//		
//		String extension = extractExtension(file.getOriginalFilename());
//		
//		fileInfo.setFileName(fileName);
//		file.transferTo(new File());
//		return fileInfo;
//	}
//	
//	private String createFileName() {
//		String fileName =UUID.randomUUID().toString();
//		fileName = fileName+","+extension;
//		return fileName;
//	}
//	
//	private String extractExtension() {
//		fileName.substring(0);
//	}
}
