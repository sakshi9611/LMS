package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.entities.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>{

}
