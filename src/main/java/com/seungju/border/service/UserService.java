package com.seungju.border.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seungju.border.dto.response.ResponseDto;
import com.seungju.border.dto.user.PostUserDto;
import com.seungju.border.dto.user.PostUserResponseDto;
import com.seungju.border.entity.MemberEntity;
import com.seungju.border.repository.MemberRepository;

@Service
public class UserService {

	@Autowired MemberRepository memberRepositroy;
	
	public ResponseDto<PostUserResponseDto> postUser(PostUserDto dto){
		String password = dto.getPassword(); 
		String password2 = dto.getPassword2(); 
	
		if(!password.equals(password2))
			return ResponseDto.setFailed("비밀번호가 서로 다릅니다.");
			
			MemberEntity member = MemberEntity
					.builder()
					.email(dto.getEmail())
					.password(dto.getPassword())
					.nickname(dto.getNickname())
					.telNumber(dto.getTelNumber())
					.address(dto.getAdress()+" "+dto.getAdressDetail())
					.build();
			memberRepositroy.save(member);
			
			return ResponseDto.setSuccess("회원가입에 성공했습니다",new PostUserResponseDto(true));
		
	}
	
}
