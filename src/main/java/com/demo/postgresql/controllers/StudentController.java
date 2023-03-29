package com.demo.postgresql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.demo.postgresql.models.request.StudentRequest;
import com.demo.postgresql.service.StudentService;

@RequestMapping("/student")
@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/create")
	@ResponseBody
	public String saveStudent(@RequestBody StudentRequest studentRequest) {
		studentService.saveStudent(studentRequest);
		return "Create successfully!!!";
	}
}
