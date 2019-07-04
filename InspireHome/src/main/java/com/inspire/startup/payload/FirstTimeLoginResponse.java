package com.inspire.startup.payload;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anoop
 *
 */
@Getter
@Setter
public class FirstTimeLoginResponse {

	private String userName;

	private String message ;
	public FirstTimeLoginResponse(String message,String userName) {
		super();
		this.message= message;
		this.userName = userName;
	}
	
	
	
	
	
}
