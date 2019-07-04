package com.inspire.startup.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inspire.startup.model.User;
import com.inspire.startup.payload.ChangePasswordUserModel;
import com.inspire.startup.payload.LoginRequest;
import com.inspire.startup.repository.UserRepository;
import com.inspire.startup.service.LoginService;


/**
 * @author Anoop
 *
 */
@RestController
@RequestMapping("/api/auth")
public class LoginController {

	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;

	
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );
        
      return  loginService.authenticateUser(authentication);
       
            }
	
	
	
	
	 @PostMapping(value = "/changePassword")
	    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordUserModel userModel) throws IOException, ServletException {

	        Optional<User> loggedInUserEntity =  userRepository.findByMobileNumberOrEmail(userModel.getMobileNumber(), userModel.getEmail());
	        loggedInUserEntity.orElseThrow(()-> new UsernameNotFoundException("No user found with given userName "+userModel.getUserName())) ;

	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder() ;
	       User usersEntity =  loggedInUserEntity.map(user->{
	            user.setUserPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
	            user.setIsMaidenLogin(true);
	            return user;
	        }).get();
	       userRepository.saveAndFlush(usersEntity);
	       
	        return ResponseEntity.ok("Password has been updated successfully");
	    }

}
