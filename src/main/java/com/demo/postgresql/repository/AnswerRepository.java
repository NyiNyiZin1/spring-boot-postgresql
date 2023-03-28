package com.demo.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.postgresql.entity.Answer;
import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
	//List<Answer> findByQuestionId(Long questionId);
	@Query(value = "SELECT * FROM answers a where a.question_id=:questionId", nativeQuery = true)
    List<Answer> findByQuestionId(@Param("questionId")Long questionId);
}