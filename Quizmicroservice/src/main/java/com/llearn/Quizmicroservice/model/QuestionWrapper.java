package com.llearn.Quizmicroservice.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class QuestionWrapper {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOp1() {
		return Op1;
	}

	public void setOp1(String op1) {
		Op1 = op1;
	}

	public String getOp2() {
		return Op2;
	}

	public void setOp2(String op2) {
		Op2 = op2;
	}

	public String getOp3() {
		return Op3;
	}

	public void setOp3(String op3) {
		Op3 = op3;
	}

	public String getOp4() {
		return Op4;
	}

	public void setOp4(String op4) {
		Op4 = op4;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	private int id;
	private String Op1;
    private	String Op2;
	private String Op3;
	private String Op4;
	private String question;
	
	public QuestionWrapper(int id, String op1, String op2, String op3, String op4, String question) {
		super();
		this.id = id;
		Op1 = op1;
		Op2 = op2;
		Op3 = op3;
		Op4 = op4;
		this.question = question;
	}
	
	
	
}
