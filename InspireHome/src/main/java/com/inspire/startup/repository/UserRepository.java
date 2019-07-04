package com.inspire.startup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.inspire.startup.model.User;

public interface UserRepository extends JpaRepository<User, Long> , JpaSpecificationExecutor<User>{

	
	
	Optional<User> findByInspireId(Long valueOf);

	Optional<User> findByUserName(String userName);
	
	Optional<User> findByUserNameOrEmail(String username, String email);
	
	Optional<User> findByMobileNumberOrEmail(String username, String email);

}
