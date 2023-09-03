package com.learn.Questionmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.Questionmicroservice.model.QuestionWrapper;
import com.learn.Questionmicroservice.model.Questions;
import com.learn.Questionmicroservice.model.Response;
import com.learn.Questionmicroservice.service.QuesService;

@RestController
@RequestMapping("questions")
public class quesController {
	
	@Autowired
	QuesService quesService;
	
	@GetMapping("allQues")
	public ResponseEntity<List<Questions>> getAllQues() {
		
		return quesService.getAllQues();
		
	}
	@GetMapping("category/{category}")
	public ResponseEntity<List<Questions>> getCategoryQues(@PathVariable String category){
		return quesService.getCategoryQues(category);
		
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Questions question) {
		
		
		return quesService.addQuestion(question);
		
	}
	 @DeleteMapping("/delete/{id}")
	 public String deleteQuestion(@PathVariable("id") int id) {
	       return quesService.deleteQuestion(id);
	 }
	 
	 @GetMapping("generate")
	 public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName ,@RequestParam int numQuestions){
		 
		 return quesService.getQuestionsForQuiz(categoryName ,numQuestions);
		 
	 }
	 
	 @PostMapping("getQuestions")
	 public ResponseEntity<List<QuestionWrapper>> getQuestionsFromID(@RequestBody List<Integer> questionID){
		
		 return quesService.getQuestionsFromID(questionID);
		 
	 }
	 
	 @PostMapping("getScore")
	 public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
		 return quesService.getScore(responses);
	 }
	 
	 
	 //generate.
	 //getQuestions
	 //get score.
	
}
