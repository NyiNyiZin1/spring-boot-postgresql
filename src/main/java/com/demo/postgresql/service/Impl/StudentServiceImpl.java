package com.demo.postgresql.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.postgresql.entity.Student;
import com.demo.postgresql.models.request.StudentRequest;
import com.demo.postgresql.repository.StudentRepo;
import com.demo.postgresql.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	public StudentRepo studentRepo;

	@Override
	public Student saveStudent(StudentRequest studentReq) {
		return studentRepo.saveAndFlush(new ModelMapper().map(studentReq, Student.class));
	}
}
