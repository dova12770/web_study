package com.app.dto.file;

import lombok.Data;

@Data
public class FileInfo {
	
	//String fileId;				//pk
	
	String fileName;			//저장된 파일이름(유니크 PK)
	String originalFileName;	//원래 파일 이름
	String filePath;			//저장된 경로
	String urlFilePath;			//url 로 요청할때 경로
	
	//extension
	//fileSize
	//fileSaveDate
	

}
