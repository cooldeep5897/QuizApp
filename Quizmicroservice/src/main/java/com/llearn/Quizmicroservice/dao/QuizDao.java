package com.llearn.Quizmicroservice.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.llearn.Quizmicroservice.model.Quiz;


public interface QuizDao extends JpaRepository<Quiz, Integer> {


}

