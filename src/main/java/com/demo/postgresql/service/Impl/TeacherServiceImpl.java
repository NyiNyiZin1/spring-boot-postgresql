package com.demo.postgresql.service.Impl;

import com.demo.postgresql.entity.Student;
import com.demo.postgresql.entity.Teacher;
import com.demo.postgresql.models.request.StudentRequest;
import com.demo.postgresql.models.request.TeacherRequest;
import com.demo.postgresql.repository.TeacherRepo;
import com.demo.postgresql.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    public TeacherRepo teacherRepo;

    @Override
    public Teacher findByStudentName(String name) {
        return teacherRepo.findByStudentName(name);
    }

    @Override
    public Teacher updateTeacher(StudentRequest studentRequest) {
        return teacherRepo.updateTeacher(studentRequest.getId());
    }

    @Override
    public Teacher createTeacher(TeacherRequest teacherRequest) {
        Student student = new Student();
        student.setId(1l);
        student.setClassRoomId(1l);
        student.setName("mg mg");
        student.setJsonObj("{\"jsonString\" : \"json string\"}");
        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherRequest.getTeacherName());
        teacher.setClassRoomId(teacherRequest.getClassRoomId());
        teacher.setStudent(student);
        return teacherRepo.save(teacher);
    }
}
