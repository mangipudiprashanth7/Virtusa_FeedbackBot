/**
 * 
 */
package com.code.chatbot.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.code.chatbot.model.Responses;

/**
 * @author mangi
 *
 */
class ResponsesDAOTest {

	/**
	 * Test method for {@link com.code.chatbot.dao.ResponsesDAO#save(com.code.chatbot.model.Responses)}.
	 */
	private ResponsesDAOImpl responsesDAOImpl;
	private DriverManagerDataSource dataSource = new DriverManagerDataSource();
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/chatbot");
		dataSource.setUsername("root");
		dataSource.setPassword("Root@123");
		
		responsesDAOImpl = new ResponsesDAOImpl(dataSource);
		
	}
	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.code.chatbot.dao.ResponsesDAO#delete(java.lang.Integer)}.
	 */
	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.code.chatbot.dao.ResponsesDAO#get(java.lang.Integer)}.
	 */
	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.code.chatbot.dao.ResponsesDAO#update(com.code.chatbot.model.Responses)}.
	 */
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.code.chatbot.dao.ResponsesDAO#list()}.
	 */
	@Test
	void testList() {
		List<Responses> responses = responsesDAOImpl.list();
		for(Responses responses2:responses)
			System.out.println(responses2);
		assertTrue(responses.isEmpty());

		};

}
