package com.demo.postgresql.service;

import com.demo.postgresql.entity.Student;
import com.demo.postgresql.entity.Teacher;
import com.demo.postgresql.models.request.StudentRequest;
import com.demo.postgresql.models.request.TeacherRequest;

public interface StudentService {
	Student saveStudent(StudentRequest studentRequest);
	Student updateStudent(StudentRequest studentRequest);
	void deleteStudentById(Long id);

	Student findByStudentName(String name);
}
