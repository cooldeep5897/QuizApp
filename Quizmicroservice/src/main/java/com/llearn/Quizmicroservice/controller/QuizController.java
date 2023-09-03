package com.llearn.Quizmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.llearn.Quizmicroservice.controller.model.QuizDto;
import com.llearn.Quizmicroservice.model.QuestionWrapper;
import com.llearn.Quizmicroservice.model.Response;
import com.llearn.Quizmicroservice.service.QuizService;


@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService quizService;

	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto ){
		
		return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQ(),quizDto.getTitle());
	
	}
	
	@GetMapping("get/{Id}")
	public ResponseEntity< List< QuestionWrapper >> getQuizQuestions(@PathVariable int Id){
		
		return quizService.getQuizQuestions(Id);
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> response) {
		return quizService.getScore(response);
	}
	
}
