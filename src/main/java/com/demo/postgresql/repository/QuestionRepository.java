package com.demo.postgresql.repository;

import com.demo.postgresql.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}