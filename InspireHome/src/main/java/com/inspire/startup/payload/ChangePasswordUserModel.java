package com.inspire.startup.payload;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ChangePasswordUserModel {

    
	private String userName;
	
	private String mobileNumber;
	
	@NotBlank
	private String password;
	
	private String email;
	
}
