package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
