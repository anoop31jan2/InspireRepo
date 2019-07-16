package com.inspire.startup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspire.startup.model.Student;
import com.inspire.startup.payload.ParentDashboardResponse;
import com.inspire.startup.repository.StudentRepository;

@Service
public class ParentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public  ParentDashboardResponse getStudentList(CustomUserDetails principal) {
		
		ParentDashboardResponse preponse = new ParentDashboardResponse();
		Integer parentId = principal.getId();
		
		List<Student> studentList = new ArrayList<>();
		
		studentList =studentRepository.findByParentId(parentId);
		
		preponse.setStudentList(studentList);
		
		return preponse;
		
	}

}
