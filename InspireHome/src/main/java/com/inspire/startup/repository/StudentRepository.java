package com.inspire.startup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspire.startup.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByParentId(Integer parentId);
	
}
