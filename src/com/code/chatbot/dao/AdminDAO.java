package com.code.chatbot.dao;

import java.util.List;

import com.code.chatbot.model.Admin;
import com.code.chatbot.model.Authenticate;

public interface AdminDAO {
	
	public int save(Admin admin);
	
	public int update(Admin admin);
	
	public int delete(Integer aid);
	
	public Admin get(Integer aid);
	
	public int verify(Authenticate authenticate);
	
	public List<Admin> list();

}
