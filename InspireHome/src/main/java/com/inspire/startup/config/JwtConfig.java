package com.inspire.startup.config;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JwtConfig {

	    @Value("${app.jwtSecret}")
	    private String jwtSecret;

	    @Value("${app.jwtExpirationInMs}")
	    private int jwtExpirationInMs;
	
	    
	    
	    @Value("${app.jwtTokenPrefix}")
	    private String jwtTokenPrefix;
	
}
