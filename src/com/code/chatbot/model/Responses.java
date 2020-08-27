package com.code.chatbot.model;

public class Responses {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getQueString() {
		return queString;
	}

	public void setQueString(String queString) {
		this.queString = queString;
	}

	public String getResponseString() {
		return responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}

	public Responses(Integer id, String user, String queString, String responseString) {
		this(user,queString,responseString);
		this.id = id;
	}

	public Responses(String user, String queString, String responseString) {
		this.queString = queString;
		this.user = user;
		this.responseString = responseString;
	}

	@Override
	public String toString() {
		return "Responses [id=" + id + ", user=" + user + ", queString=" + queString + ", responseString="
				+ responseString + "]";
	}

	private Integer id;
	private String user;
	private String queString;
	private String responseString;

}
