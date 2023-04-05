package com.demo.postgresql.controllers;

import com.demo.postgresql.entity.Teacher;
import com.demo.postgresql.models.request.StudentRequest;
import com.demo.postgresql.models.request.TeacherRequest;
import com.demo.postgresql.service.StudentService;
import com.demo.postgresql.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/teacher")
@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/get/{name}")
    public Teacher findByStudentName(@PathVariable("name") String name) {
        return teacherService.findByStudentName(name);
    }

    @PostMapping("/create")
    public Teacher createTeacher(@RequestBody TeacherRequest teacherRequest) {
        return teacherService.createTeacher(teacherRequest);
    }

    @PutMapping("/update")
    public Teacher updateTeacher(@RequestBody StudentRequest studentRequest) {
        return teacherService.updateTeacher(studentRequest);
    }
}
