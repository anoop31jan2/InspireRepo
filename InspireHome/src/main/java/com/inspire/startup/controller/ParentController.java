package com.inspire.startup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inspire.startup.model.INSProfile;
import com.inspire.startup.payload.ParentDashboardResponse;
import com.inspire.startup.service.CustomUserDetails;
import com.inspire.startup.service.ParentService;

/**
 * @author Anoop
 *
 */
@RestController
@RequestMapping("/inspire")
public class ParentController {
	
	@Autowired
	private ParentService parentService;

	@GetMapping("/parent/students")
	public ResponseEntity<?> getStudentList() {
		
		
		CustomUserDetails principal = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		ParentDashboardResponse parentDashboardResponse = parentService.getStudentList(principal);
		
		return ResponseEntity.ok(parentDashboardResponse);
	}
	
	
	
	@GetMapping("/profile/{profileId}")
	public ResponseEntity<?> getProfileInfo(@PathVariable("profileId") Integer profileId){
		
		INSProfile insProfile = parentService.getProfileInfo(profileId);
		
		return ResponseEntity.ok(insProfile);
		
	}
	
}
