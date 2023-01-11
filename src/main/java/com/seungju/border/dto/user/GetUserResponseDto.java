package com.seungju.border.dto.user;

	import com.seungju.border.entity.MemberEntity;

import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class GetUserResponseDto {
		private String email;
		private String nickname;
		private String profile;
		private String telNumber;
		private String address;
		private String addressDetail;


		public GetUserResponseDto(MemberEntity member) {
			this.email = member.getEmail();
			this.nickname = member.getNickname();
			this.profile = member.getProfile();
			this.telNumber = member.getTelNumber();
			this.address = member.getAddress();
		}
	}
