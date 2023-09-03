package com.llearn.Quizmicroservice.controller.model;

import lombok.Data;

@Data
public class QuizDto {

	String categoryName;
	Integer numQ;
	public Integer getNumQ() {
		return numQ;
	}
	public void setNumQ(Integer numQ) {
		this.numQ = numQ;
	}
	String title;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
