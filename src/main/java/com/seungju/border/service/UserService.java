package com.seungju.border.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seungju.border.dto.response.ResponseDto;
import com.seungju.border.dto.user.GetUserResponseDto;
import com.seungju.border.dto.user.PatchUserDto;
import com.seungju.border.dto.user.PostUserDto;
import com.seungju.border.dto.user.ResultResponseDto;
import com.seungju.border.entity.MemberEntity;
import com.seungju.border.repository.MemberRepository;

@Service
public class UserService {
	
	@Autowired MemberRepository memberRepository;
	
	public ResponseDto<GetUserResponseDto> getUser(String email) {
		// 해당 이메일을 데이터베이스에서 검색
		MemberEntity member;
		try {
			member = memberRepository.findById(email).get();
		} 
		// 존재하지않으면 "Not Exist User" 메세지를 포함한 Failed Response 반환
		catch (Exception e) {
			return ResponseDto.setFailed("Not Exist User");
		}
		// 존재하면 User정보 반환
		// 1
//		GetUserResponseDto responseData = new GetUserResponseDto();
//		responseData.setEmail(member.getEmail());
//		responseData.setNickname(member.getNickname());
//		responseData.setProfile(member.getProfile());
//		responseData.setTelNumber(member.getTelNumber());
//		responseData.setAddress(member.getAddress());
//		
//		return ResponseDto.setSuccess("Get User Success", responseData);
		
		// 2
//		GetUserResponseDto responseData = 
//				GetUserResponseDto
//				.builder()
//				.email(member.getEmail())
//				.nickname(member.getNickname())
//				.profile(member.getProfile())
//				.telNumber(member.getTelNumber())
//				.address(member.getAddress())
//				.build();
//		
//		return ResponseDto.setSuccess("Get User Success", responseData);
		
		// 3
//		return ResponseDto.setSuccess(
//				"Get User Success", 
//				new GetUserResponseDto(
//					member.getEmail(), 
//					member.getNickname(), 
//					member.getProfile(), 
//					member.getTelNumber(), 
//					member.getAddress()
//				)
//			);
		
		return ResponseDto.setSuccess("Get User Success", new GetUserResponseDto(member));
	}

	public ResponseDto<ResultResponseDto> postUser(PostUserDto dto) {
		
		// 데이터베이스에 해당 이메일이 존재하는지 체크
		// 존재한다면 Failed Response를 반환
		String email = dto.getEmail();
		
		try {
			if (memberRepository.existsById(email)) 
				return ResponseDto.setFailed("이미 존재하는 이메일입니다.");
		} catch (Exception e) {
			return ResponseDto.setFailed("데이터베이스 오류입니다.");
		}
		
//		try {
//			memberRepository.findById(email).get();
//		} catch (Exception e) {
//			return ResponseDto.setFailed("이미 존재하는 이메일입니다.");
//		}
		
		
		String password = dto.getPassword();
		String password2 = dto.getPassword2();
		
		if (!password.equals(password2)) return ResponseDto.setFailed("비밀번호가 서로 다릅니다.");
		
		MemberEntity member = MemberEntity
				.builder()
				.email(dto.getEmail())
				.password(dto.getPassword())
				.nickname(dto.getNickname())
				.telNumber(dto.getTelNumber())
				.address(dto.getAddress() + " " + dto.getAdressDetail())
				.build();
		
		// JpaRepository.save(Entity) 메서드
		// 해당 Entity Id가 데이터베이스 테이블에 존재하지 않으면!
		// Entity INSERT 작업을 수행
		// !!! 하지만 !!!
		// 해당 Entity Id가 데이터베이스 테이블에 존재하면!
		// 존재하는 Entity UPDATE 작업을 수행 
		memberRepository.save(member);
		
		return ResponseDto.setSuccess("회원가입에 성공했습니다.", new ResultResponseDto(true));
	}
	public ResponseDto<GetUserResponseDto> patchUser(PatchUserDto dto){
		//dto에서 이메일을 가져옴
		String email = dto.getEmail();
		
		// repository를 이용해서 데이터베이스에 있는 member 테이블 중 
		// email에 해당하는 데이터를 불러옴
		MemberEntity member =null;
		try {
			member = memberRepository.findById(email).get();			
		} catch(Exception e) {
			//만약 존재하지 않으면 "Not Exist User" 반환
			return ResponseDto.setFailed("Not Exist User");
		}
		
		// Request Boby로 받은 nickname과 profile로 각각 변경
		member.setNickname(dto.getNickname());
		member.setProfile(dto.getProfile());
		
		//변경한 entity를 repository를 이용해서 데이터베이스에 적용(저장)
		memberRepository.save(member);
		
		//결과를 ResponseDto에 담아서 반환
		return ResponseDto.setSuccess("User Patch Sucess", new GetUserResponseDto(member));
	}
	public ResponseDto<ResultResponseDto> deleteUser(String email){
		// repository를 이용해서 데이터베이스에 있는 Member 테이블 중
		// email에 해당하는 데이터를 삭제
		memberRepository.deleteById(email);
		
		return ResponseDto.setSuccess("Delete User Success", new ResultResponseDto(true));
		}
}