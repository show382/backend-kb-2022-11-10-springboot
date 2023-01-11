package com.seungju.border.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("file/")
public class FileController {
	
	//파일을 서버에 업로드 post 쓰면됌
	@PostMapping()
	
	//파일을 서버에서 다운로드 get 쓰면됌
	@GetMapping()
	
	//이미지파일 일 경우 이미지를 출력 get 쓰면됌
	@GetMapping()
	
}
