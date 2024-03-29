package com.inspire.startup.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.inspire.startup.config.JwtConfig;
import com.inspire.startup.service.CustomUserDetails;

import java.util.Date;


/**
 * @author Anoop
 *
 */
@Component
public class JwtTokenProvider {

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

	@Autowired
	private JwtConfig jwtConfig;


	public String generateToken(Authentication authentication) {

		CustomUserDetails userPrincipal = (CustomUserDetails) authentication.getPrincipal();

		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtConfig.getJwtExpirationInMs());

		return Jwts.builder()
				.setSubject(Long.toString(userPrincipal.getId()))
				.setIssuedAt(new Date())
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, jwtConfig.getJwtSecret())
				.compact();
	}

	public Integer getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(jwtConfig.getJwtSecret())
				.parseClaimsJws(token)
				.getBody();

		return Integer.parseInt(claims.getSubject());
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtConfig.getJwtSecret()).parseClaimsJws(authToken);
			return true;


		} catch (SignatureException ex) {
			logger.error("Invalid JWT signature");

		} catch (MalformedJwtException ex) {
			logger.error("Invalid JWT token");

		} catch (ExpiredJwtException ex) {
			logger.error("Expired JWT token");

		} catch (UnsupportedJwtException ex) {
			logger.error("Unsupported JWT token");

		} catch (IllegalArgumentException ex) {
			logger.error("JWT claims string is empty.");

		}
		return false;
	}
}
