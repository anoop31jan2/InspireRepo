package com.inspire.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspire.startup.model.INSProfile;

public interface INSProfileRepository extends JpaRepository<INSProfile, Integer> {
	
	
}
