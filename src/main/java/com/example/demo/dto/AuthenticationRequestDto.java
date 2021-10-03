package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthenticationRequestDto {

		private String username;
	    private String password;

	    public AuthenticationRequestDto(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }
}
