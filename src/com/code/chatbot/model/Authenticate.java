package com.code.chatbot.model;

public class Authenticate {
	private String emailString;
	private String passwordString;

	public String getEmailString() {
		return emailString;
	}

	@Override
	public String toString() {
		return "Authenticate [emailString=" + emailString + ", passwordString=" + passwordString + "]";
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}

	public Authenticate(String emailString, String passwordString) {
		super();
		this.emailString = emailString;
		this.passwordString = passwordString;
	}

	public Authenticate() {
		// TODO Auto-generated constructor stub
	}
}
