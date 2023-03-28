
package com.demo.postgresql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.demo.postgresql.entity.Answer;

public interface AnswerService {
	List<Answer> findByQuestionId(Long questionId);

	Answer addAnswer(Long questionId, Answer answer);

	Answer updateAnswer(Long questionId, Long answerId, Answer answerRequest);

	ResponseEntity<?> deleteAnswer(Long questionId, Long answerId);
}
