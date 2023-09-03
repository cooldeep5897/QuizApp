package com.learn.Questionmicroservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn.Questionmicroservice.model.Questions;

@Repository
public interface QuestionDao extends  JpaRepository<Questions,Integer>{

	List<Questions> findByCategory(String category);

	@Query(value="select q.id from questions q where q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery=true)
	List<Integer> findRandomQuestionsByCategory(String category, int numQ);

}
