package com.inspire.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspire.startup.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByrole(String role) ;
}
