package com.learn.Questionmicroservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Questions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String category;
	private String Difficulty;
	private String Op1;
    private	String Op2;
	private String Op3;
	private String Op4;
	private String question;
	private String correctop;
	

	public String getCorrectop() {
		return correctop;
	}
	public void setCorrectop(String correctop) {
		this.correctop = correctop;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDifficulty() {
		return Difficulty;
	}
	public void setDifficulty(String difficulty) {
		Difficulty = difficulty;
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

	
}
