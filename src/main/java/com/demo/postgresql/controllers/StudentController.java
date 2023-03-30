package com.demo.postgresql.controllers;

import com.demo.postgresql.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.postgresql.models.request.StudentRequest;
import com.demo.postgresql.service.StudentService;

@RequestMapping("/student")
@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/create")
	public String saveStudent(@RequestBody StudentRequest studentRequest) {
		studentService.saveStudent(studentRequest);
		return "Create successfully!!!";
	}

	@PutMapping("/update")
	public String updateStudent(@RequestBody StudentRequest studentRequest) {
		studentService.updateStudent(studentRequest);
		return "Updated successfully!!!";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudentById(@PathVariable("id") Long id) {
		studentService.deleteStudentById(id);
		return "Deleted successfully!!!";
	}

	@GetMapping("/get/{name}")
	public Student findByStudentName(@PathVariable("name") String name) {
		return studentService.findByStudentName(name);
	}
}
