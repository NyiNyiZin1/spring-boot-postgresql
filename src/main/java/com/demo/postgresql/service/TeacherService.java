package com.demo.postgresql.service;

import com.demo.postgresql.entity.Teacher;
import com.demo.postgresql.models.request.StudentRequest;
import com.demo.postgresql.models.request.TeacherRequest;

public interface TeacherService {
    Teacher findByStudentName(String name);

    Teacher createTeacher(TeacherRequest teacherRequest);

    Teacher updateTeacher(StudentRequest teacherRequest);
}
