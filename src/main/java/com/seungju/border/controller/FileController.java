package com.seungju.border.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.net.HttpHeaders;
import com.seungju.border.service.FileService;

@RestController
@RequestMapping("file/")
public class FileController {

	@Autowired
	FileService fileService;

	// 파일을 서버에 업로드 post 쓰면됌
	@PostMapping("upload")
	// Param 하나하나 받을때 사용
	// Request body에 파일을 받아 올땐 MultipartFile 인스턴스로 받음
	public String fileUpload(@RequestParam("file") MultipartFile file) {
		return fileService.fileUpload(file);
	}

	//파일을 서버에서 다운로드 get 쓰면됌
	@GetMapping("download/{fileName}")
	public ResponseEntity<Resource> fileDownload(@PathVariable("fileName")String fileName){
		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" + fileName)
				.body(fileService.fileDownload(fileName));
	}
	
	
//	//이미지파일 일 경우 이미지를 출력 get 쓰면됌
	@GetMapping(value="image/{imageName}", produces ={MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE})
	public Resource getImage(@PathVariable("imageName")String imageName) {
		return fileService.getImage(imageName);
	}

}
