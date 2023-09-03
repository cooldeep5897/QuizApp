package com.learn.Questionmicroservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.Questionmicroservice.dao.QuestionDao;
import com.learn.Questionmicroservice.model.QuestionWrapper;
import com.learn.Questionmicroservice.model.Questions;
import com.learn.Questionmicroservice.model.Response;

@Service
public class QuesService {
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Questions>> getAllQues() {
		
		try {
			return new ResponseEntity<>( questionDao.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<List<Questions>> getCategoryQues(String category) {
		try {
			return new ResponseEntity<>( questionDao.findByCategory(category), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
			
	}

	public ResponseEntity<String> addQuestion(Questions question) {
		try {
		questionDao.save(question);
		return new ResponseEntity<>("added successfully", HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("added successfully", HttpStatus.BAD_REQUEST);

		
	}

	public String deleteQuestion(int id) {
		questionDao.deleteById(id);
		return "Deleted successfully";
	}

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, int numQuestions) {
		
		
			List<Integer> questions =questionDao.findRandomQuestionsByCategory(categoryName,numQuestions);
		
		
		
			return new ResponseEntity<>(questions, HttpStatus.OK);
	
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromID(List<Integer> questionID) {
		
		List<QuestionWrapper> wrappers =new ArrayList();
		List<Questions> questions=new ArrayList(); 
		
		for(int id: questionID) {
			questions.add(questionDao.findById(id).get());
		}
		
		for(Questions question:questions) {
			QuestionWrapper wrapper=new QuestionWrapper();
			wrapper.setId( question.getId());
			wrapper.setOp1(	question.getOp1());
			wrapper.setOp2(question.getOp2());	
			wrapper.setOp3(question.getOp3());	
			wrapper.setOp4(question.getOp4());	
			wrapper.setQuestion(question.getQuestion());
			
			
			wrappers.add(wrapper);
		}
		
		return new ResponseEntity<>(wrappers,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		
		int right=0;
		for(Response response: responses) {
			Questions question= questionDao.findById(response.getId()).get();
		
			if(response.getResponse().equals(question.getCorrectop()))
				right++;
		
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}


}
