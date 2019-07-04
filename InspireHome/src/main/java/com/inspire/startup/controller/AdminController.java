package com.inspire.startup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inspire.startup.model.User;
import com.inspire.startup.repository.UserRepository;

@RestController
@RequestMapping("/secure")
public class AdminController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add")
	public User addUserByAdmin(@RequestBody User user) {

		String pwd = user.getUserPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.setUserPassword(encryptPwd);

		userRepository.save(user);

		return user;
	}

}
