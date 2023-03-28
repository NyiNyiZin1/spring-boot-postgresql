package com.demo.postgresql.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.postgresql.entity.Question;
import com.demo.postgresql.exception.ResourceNotFoundException;
import com.demo.postgresql.repository.QuestionRepository;
import com.demo.postgresql.repository.QuestionRepositoryPage;
import com.demo.postgresql.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionRepositoryPage questionRepositoryPage;

	@Override
	public Page<Question> findAll(Pageable pageable) {
		return questionRepositoryPage.findAllQuestion(pageable);
	}

	@Override
	public Question save(Question question) {
		return questionRepository.save(question);
	}
	
	@Override
	public Question updateQuestion(Long questionId, Question questionRequest) {
		return questionRepository.findById(questionId).map(question -> {
			question.setTitle(questionRequest.getTitle());
			question.setDescription(questionRequest.getDescription());
			return questionRepository.save(question);
		}).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
	}

	@Override
	public ResponseEntity<?> deleteQuestion(Long questionId) {
		return questionRepository.findById(questionId).map(question -> {
			questionRepository.delete(question);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
	}

}
