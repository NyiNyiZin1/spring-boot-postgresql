package com.demo.postgresql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.postgresql.entity.Question;
import com.demo.postgresql.service.QuestionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@GetMapping
	public Page<Question> getQuestions(Pageable pageable) {
		return questionService.findAll(pageable);
	}

	@PostMapping
	public Question createQuestion(@Valid @RequestBody Question question) {
		return questionService.save(question);
	}

	@PutMapping("/{questionId}")
	public Question updateQuestion(@PathVariable Long questionId, @Valid @RequestBody Question questionRequest) {
		return questionService.updateQuestion(questionId, questionRequest);
	}

	@DeleteMapping("/{questionId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
		return questionService.deleteQuestion(questionId);
	}
}