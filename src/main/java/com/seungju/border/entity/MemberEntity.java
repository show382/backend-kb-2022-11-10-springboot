package com.seungju.border.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* Member
* 이메일
* 비밀번호
* 닉네임
* 프로필 사진
* 전화번호
* 주소
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//해당 클래스가 Entity 클래스임을 명시
//인자로 지정한 일므으로 매핑
@Entity(name="MEMBER")
@Table(name="MEMBER")
public class MemberEntity {
	
	//해당 필드가 Primary Key 임을 명시
	@Id
	//해당 Primary Key를 자동 생성을 지시
	@GeneratedValue
	private String email;
	private String password;
	private String nickname;
	private String profile;
	private String telNumber;
	private String address;
	
}
