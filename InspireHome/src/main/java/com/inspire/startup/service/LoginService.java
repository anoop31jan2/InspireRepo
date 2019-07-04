package com.inspire.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.inspire.startup.payload.FirstTimeLoginResponse;
import com.inspire.startup.payload.JwtAuthenticationResponse;
import com.inspire.startup.security.JwtTokenProvider;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class LoginService {

	@Autowired
    JwtTokenProvider tokenProvider;
	
	
	public ResponseEntity<?> authenticateUser( Authentication authentication)
	{
		
		
		
		CustomUserDetails principal = (CustomUserDetails)authentication. getPrincipal();
        if (principal instanceof UserDetails) {
        String username = principal. getUsername();
        
        if(!principal.isFirstTimeLogin())
          
        return ResponseEntity.ok(new FirstTimeLoginResponse("Please change your default password",username));
        
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
		
		
	}
	
	
	
	
}
