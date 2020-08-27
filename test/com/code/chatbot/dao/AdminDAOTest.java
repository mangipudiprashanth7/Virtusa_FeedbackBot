/**
 * 
 */
package com.code.chatbot.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.code.chatbot.model.Admin;
import com.code.chatbot.model.Authenticate;

/**
 * @author mangi
 *
 */
class AdminDAOTest {

	/**
	 * Test method for
	 * {@link com.code.chatbot.dao.AdminDAO#save(com.code.chatbot.model.Admin)}.
	 */
	private AdminDAOImpl dao;
	private DriverManagerDataSource dataSource = new DriverManagerDataSource();
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/chatbot");
		dataSource.setUsername("root");
		dataSource.setPassword("Root@123");
		
		dao = new AdminDAOImpl(dataSource);
		
	}
	@Test
	void testSave() {
		Admin admin = new Admin("Test", "test@mail.com", "testpassword");
		int result = dao.save(admin);
		
		assertTrue(result>0);
	}

	/**
	 * Test method for
	 * {@link com.code.chatbot.dao.AdminDAO#update(com.code.chatbot.model.Admin)}.
	 */
	@Test
	void testUpdate() {
		Admin admin = new Admin(1, "TestUpdate", "test@test.com", "testsuccess");
		int result = dao.update(admin);
		
		assertTrue(result>0);
	}

	/**
	 * Test method for {@link com.code.chatbot.dao.AdminDAO#get(java.lang.Integer)}.
	 */
	@Test
	void testGet() {
		Integer id=1;
		Admin admin = dao.get(id);
		if(admin != null)
			System.out.println(admin);
		
		assertNotNull(admin);
		
	}
	
	@Test
	void testDelete() {
		Integer idInteger = 1;
		int result =  dao.delete(idInteger);
		assertTrue(result>0);

	}
	/**
	 * Test method for {@link com.code.chatbot.dao.AdminDAO#list()}.
	 */
	@Test
	void testList() {
		
		
	}
	
	@Test
	void testVerify() {
		Authenticate authenticate = new Authenticate("sherlock@mail.com", "sherlock");
		int result = dao.verify(authenticate);
		System.out.println(result);
		assertTrue(result>0);
		
	}

}
