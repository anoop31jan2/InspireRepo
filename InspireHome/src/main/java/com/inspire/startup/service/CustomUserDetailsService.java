package com.inspire.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspire.startup.exception.ResourceNotFoundException;
import com.inspire.startup.model.User;
import com.inspire.startup.repository.UserRepository;

/**
 * @author Anoop
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{

	 @Autowired
	    UserRepository userRepository;

	    @Override
	    @Transactional
	    public UserDetails loadUserByUsername(String mobileNumberOrEmail)
	            throws UsernameNotFoundException {
	        // Let people login with either mobile number or email
	        User user = userRepository.findByMobileNumberOrEmail(mobileNumberOrEmail, mobileNumberOrEmail)
	                .orElseThrow(() ->
	                        new UsernameNotFoundException("User not found with username or email : " + mobileNumberOrEmail)
	        );

	        return CustomUserDetails.create(user);
	    }

	 // This method is used by JWTAuthenticationFilter
	    @Transactional
	    public UserDetails loadUserById(Long id) {
	        User user = userRepository.findByInspireId(id).orElseThrow(
	            () -> new ResourceNotFoundException("User", "id", id)
	        );

	        return CustomUserDetails.create(user);
	    }

}
