package com.llearn.Quizmicroservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.llearn.Quizmicroservice.model.QuestionWrapper;
import com.llearn.Quizmicroservice.model.Response;


@FeignClient("QUESTIONS-SERVICE")
public interface QuizInterface {

	 @GetMapping("questions/generate")
	 public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName ,@RequestParam int numQuestions);
	 	
	 @PostMapping("questions/getQuestions")
	 public ResponseEntity<List<QuestionWrapper>> getQuestionsFromID(@RequestBody List<Integer> questionID);
	 
	 @PostMapping("questions/getScore")
	 public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
