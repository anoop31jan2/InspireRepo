package com.inspire.startup.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inspire.startup.service.CustomUserDetails;

@RestController
@RequestMapping("/inspire")
public class ParentController {

	@GetMapping("/hello")
	public String syaHello() {
		
		String username=null;
		CustomUserDetails principal = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails)
			username= principal.getUsername();
			
		return "Hello Parent, welcome to the Inspire world "+username;
	}
	
	
}
