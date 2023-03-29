package com.demo.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.postgresql.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	
}
