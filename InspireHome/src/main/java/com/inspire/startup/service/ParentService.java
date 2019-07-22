package com.inspire.startup.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspire.startup.exception.ResourceNotFoundException;
import com.inspire.startup.model.INSProfile;
import com.inspire.startup.model.Student;
import com.inspire.startup.payload.ParentDashboardResponse;
import com.inspire.startup.repository.INSProfileRepository;
import com.inspire.startup.repository.StudentRepository;
import com.inspire.startup.util.ExceptionConstants;

/**
 * @author Anoop
 *
 */
@Service
public class ParentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private INSProfileRepository profileRepository;

	/**
	 * @param principal
	 * @return
	 */
	public  ParentDashboardResponse getStudentList(CustomUserDetails principal) {

		ParentDashboardResponse preponse = new ParentDashboardResponse();
		Integer parentId = principal.getId();

		List<Student> studentList = new ArrayList<>();

		studentList =studentRepository.findByParentId(parentId);
		
		if(studentList.size() == 0) {

			throw new ResourceNotFoundException(ExceptionConstants.STUDENT, ExceptionConstants.PARENT_ID, parentId);
		}

		preponse.setStudentList(studentList);

		return preponse;

	}

	
	
	/**
	 * @param profileId
	 * @return
	 */
	public INSProfile getProfileInfo(Integer profileId) {
		
		INSProfile profile = profileRepository.findById(profileId).
				orElseThrow(()-> new ResourceNotFoundException(ExceptionConstants.INS_PROFILE, ExceptionConstants.INSP_ID, profileId));
		
		return profile;
	}

}
