package com.code.chatbot.model;

public class Questions {
	@Override
	public String toString() {
		return "Questions [id=" + id + ", question=" + question + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	private Integer id;
	private String question;

	public Questions(Integer id, String question) {
		this(question);
		this.id = id;
	}

	public Questions(String question) {
		this.question = question;
	}

}
