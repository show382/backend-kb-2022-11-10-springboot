package com.seungju.border.dto.user;

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
	}

