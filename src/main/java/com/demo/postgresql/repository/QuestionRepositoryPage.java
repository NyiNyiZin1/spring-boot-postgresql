package com.demo.postgresql.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.postgresql.entity.Question;

public interface QuestionRepositoryPage extends PagingAndSortingRepository<Question, Long> {
	@Query(value = "SELECT q FROM Question q")
	Page<Question> findAllQuestion(Pageable pageable);
}
