package com.seungju.border;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Builder;

@Builder
@SpringBootApplication
public class BorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorderApplication.class, args);
	}

}
