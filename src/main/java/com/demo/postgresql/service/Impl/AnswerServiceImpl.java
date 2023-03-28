package com.demo.postgresql.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.demo.postgresql.entity.Answer;
import com.demo.postgresql.exception.ResourceNotFoundException;
import com.demo.postgresql.repository.AnswerRepository;
import com.demo.postgresql.repository.QuestionRepository;
import com.demo.postgresql.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Override
	public List<Answer> findByQuestionId(Long questionId) {
		return answerRepository.findByQuestionId(questionId);
	}

	@Override
	public Answer addAnswer(Long questionId, Answer answer) {
		return questionRepository.findById(questionId).map(question -> {
			answer.setQuestion(question);
			return answerRepository.save(answer);
		}).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
	}

	@Override
	public Answer updateAnswer(Long questionId, Long answerId, Answer answerRequest) {
		if (!questionRepository.existsById(questionId)) {
			throw new ResourceNotFoundException("Question not found with id " + questionId);
		}
		return answerRepository.findById(answerId).map(answer -> {
			answer.setText(answerRequest.getText());
			return answerRepository.save(answer);
		}).orElseThrow(() -> new ResourceNotFoundException("Answer not found with id " + answerId));
	}

	@Override
	public ResponseEntity<?> deleteAnswer(Long questionId, Long answerId) {
		if (!questionRepository.existsById(questionId)) {
			throw new ResourceNotFoundException("Question not found with id " + questionId);
		}
		return answerRepository.findById(answerId).map(answer -> {
			answerRepository.delete(answer);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Answer not found with id " + answerId));
	}
}
