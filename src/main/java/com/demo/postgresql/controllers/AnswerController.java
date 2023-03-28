package com.demo.postgresql.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.postgresql.entity.Answer;
import com.demo.postgresql.service.AnswerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/questions")
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@GetMapping("/{questionId}/answers")
	public List<Answer> getAnswersByQuestionId(@PathVariable Long questionId) {
		return answerService.findByQuestionId(questionId);
	}

	@PostMapping("/{questionId}/answers")
	public Answer addAnswer(@PathVariable Long questionId, @Valid @RequestBody Answer answer) {
		return answerService.addAnswer(questionId, answer);
	}

	@PutMapping("/{questionId}/answers/{answerId}")
	public Answer updateAnswer(@PathVariable Long questionId, @PathVariable Long answerId,
			@Valid @RequestBody Answer answerRequest) {
		return answerService.updateAnswer(questionId, answerId, answerRequest);
	}

	@DeleteMapping("/{questionId}/answers/{answerId}")
	public ResponseEntity<?> deleteAnswer(@PathVariable Long questionId, @PathVariable Long answerId) {
		return answerService.deleteAnswer(questionId, answerId);
	}
}