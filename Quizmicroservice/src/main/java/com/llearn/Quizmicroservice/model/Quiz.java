package com.llearn.Quizmicroservice.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Quiz {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String title;
	

	@ElementCollection
	private List<Integer> questionIds;
	
	public List<Integer> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
