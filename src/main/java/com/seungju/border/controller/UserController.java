package com.seungju.border.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seungju.border.dto.response.ResponseDto;
import com.seungju.border.dto.user.PostUserDto;
import com.seungju.border.dto.user.PostUserResponseDto;
import com.seungju.border.service.UserService;

@RestController
@RequestMapping("api/user/")
public class UserController {

	@Autowired UserService userService;
	
	@PostMapping("")
	public ResponseDto<PostUserResponseDto> postUser(@RequestBody PostUserDto requestBody){
		return userService.postUser(requestBody);
	}
	
}
