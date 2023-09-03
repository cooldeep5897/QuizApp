package com.llearn.Quizmicroservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.llearn.Quizmicroservice.dao.QuizDao;
import com.llearn.Quizmicroservice.feign.QuizInterface;
import com.llearn.Quizmicroservice.model.QuestionWrapper;
import com.llearn.Quizmicroservice.model.Quiz;
import com.llearn.Quizmicroservice.model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;
	

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		
		
		List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();//call
		
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success" , HttpStatus.CREATED);
	}


	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		
		Quiz quiz=	quizDao.findById(id).get();
		List<Integer> listOfQuestionIds=quiz.getQuestionIds();
		
//		Optional<Quiz> quiz= quizDao.findById(id);
//		List<Questions> listOfQuestions=quiz.get().getQuestions();		
		ResponseEntity<List<QuestionWrapper>> listOfQuestionWrapper=quizInterface.getQuestionsFromID(listOfQuestionIds);
//		for(Questions q:  listOfQuestions) {
//			listOfQuestionWrapper.add(new QuestionWrapper(q.getId(),q.getOp1(),q.getOp2(),q.getOp3(),q.getOp4(),q.getQuestion()));
//		}
		
		return listOfQuestionWrapper;
		
	}

	public ResponseEntity<Integer> getScore(List<Response> response) {
		
		ResponseEntity<Integer> score=quizInterface.getScore(response);
		return score;
	}


	


}
