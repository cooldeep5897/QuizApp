package com.learn.Questionmicroservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {

	private int Id;
	private String response;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
}
