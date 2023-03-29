package com.demo.postgresql.service;

import com.demo.postgresql.entity.Student;
import com.demo.postgresql.models.request.StudentRequest;

public interface StudentService {
	Student saveStudent(StudentRequest studentRequest);
}
