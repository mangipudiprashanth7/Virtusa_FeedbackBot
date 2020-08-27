package com.code.chatbot.dao;

import java.util.List;

import com.code.chatbot.model.Responses;

public interface ResponsesDAO {
	
	public int save(Responses responses);
	
	public int delete(Integer id);
	
	public Responses get(Integer id);
	
	public int update(Responses responses);
	
	public List<Responses> list();

}
