package com.demo.postgresql.service.Impl;

import com.demo.postgresql.entity.Teacher;
import com.demo.postgresql.models.request.TeacherRequest;
import com.demo.postgresql.repository.TeacherRepo;
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
		return studentRepo.save(new ModelMapper().map(studentReq, Student.class));
	}

	@Override
	public Student updateStudent(StudentRequest studentRequest) {
		return studentRepo.saveAndFlush(new ModelMapper().map(studentRequest, Student.class));
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepo.deleteById(id);
	}

	@Override
	public Student findByStudentName(String name) {
		return studentRepo.findByStudentName(name);
	}
}
