package com.code.chatbot.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.code.chatbot.dao.AdminDAO;
import com.code.chatbot.dao.AdminDAOImpl;
import com.code.chatbot.dao.ResponsesDAO;
import com.code.chatbot.dao.ResponsesDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.code.chatbot")
public class SpringMvcConfig implements WebMvcConfigurer{
	
	
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/chatbot");
		dataSource.setUsername("root");
		dataSource.setPassword("Root@123");
		
		return dataSource;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean 
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Bean
	public AdminDAO getAdminDAO() {
		return new AdminDAOImpl(getDataSource());
	}
	
	@Bean
	public ResponsesDAO getResponsesDAO() {
		return new ResponsesDAOImpl(getDataSource());
	}
}
