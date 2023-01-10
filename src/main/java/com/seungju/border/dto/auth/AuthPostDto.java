package com.seungju.border.dto.auth;

import javax.validation.constraints.Email;
import org.antlr.v4.runtime.misc.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthPostDto {
	@NotNull
	@Email
	private String email;
	private String password;
}
