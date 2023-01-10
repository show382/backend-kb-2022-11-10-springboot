package com.seungju.border.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seungju.border.dto.auth.AuthPostDto;
import com.seungju.border.dto.auth.LoginDto;

import com.seungju.border.dto.response.ResponseDto;
import com.seungju.border.entity.MemberEntity;
import com.seungju.border.repository.MemberRepository;

// @Service : 해당 클래스가 Service 레이어 역활을 함
@Service
public class AuthService {
	
	@Autowired MemberRepository memberReposotory;
	
	public String hello(){
		//Entity Class로 entity 빌드
		MemberEntity memberEntity = 
				MemberEntity
				.builder()
				.email("show382@naver.com")
				.password("123123")
				.nickname("seungju")
				.telNumber("010-5457-5741")
				.address("busan")
				.build();
		//빌드한 Entity를 데이터베이스에 저장
		memberReposotory.save(memberEntity);
		
		//MemberRepository가 상속받은 JpaRepository 메서드를 사용하여 데이터 검색
		MemberEntity savedMemberEntity =
		memberReposotory.findById("show382@naver.com").get();
		
		//MemberRepository에 작성한 커스텀 메서드를 사용
		List<MemberEntity> list = memberReposotory.myFindAll("show382@naver.com");
		System.out.println(list.toString());
		
		return savedMemberEntity.getNickname();
		
		
	}
	
	public ResponseDto<LoginDto> login(AuthPostDto dto) {
		LoginDto result = new LoginDto("MSJ",3600000);
		return ResponseDto.setSuccess("", result);
	}

}
