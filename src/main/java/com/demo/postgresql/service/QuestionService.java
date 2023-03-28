package com.demo.postgresql.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.demo.postgresql.entity.Question;

public interface QuestionService {
	Page<Question> findAll(Pageable pageable);

	Question save(Question question);

	Question updateQuestion(Long questionId, Question questionRequest);

	ResponseEntity<?> deleteQuestion(Long questionId);
}
