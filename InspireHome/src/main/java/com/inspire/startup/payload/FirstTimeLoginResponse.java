package com.inspire.startup.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Anoop
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class FirstTimeLoginResponse {

	private String mobileNumber;
	
	private String email;

	private String message ;
	public FirstTimeLoginResponse(String message,String mobileNumber,String email) {
		super();
		this.message= message;
		this.mobileNumber = mobileNumber;
		this.email=email;
	}
	
	
	
	
	
}
