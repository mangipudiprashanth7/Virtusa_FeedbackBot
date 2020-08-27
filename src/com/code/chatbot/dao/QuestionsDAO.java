package com.code.chatbot.dao;

import java.util.List;

import com.code.chatbot.model.Questions;

public interface QuestionsDAO {
	
	public int save(Questions questions);
	
	public int update(Questions questions);
	
	public Questions get(Integer id);
	
	public int delete(Integer id);
	
	public List<Questions> list();
	

}
