package com.code.chatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.code.chatbot.dao.AdminDAO;
import com.code.chatbot.dao.ResponsesDAO;
import com.code.chatbot.model.Admin;
import com.code.chatbot.model.Authenticate;
import com.code.chatbot.model.Questions;
import com.code.chatbot.model.Responses;

/*
 * Landing Page -> "/" -> index.jsp
 * Landing Page contains the login authentication using the db and new admin registration, also the chat button
 * Chat button will take the user to the Chat page
 * After the admin completes the login then we'll display the complete db related to the feedback
 */
@Controller
public class MainController {

	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private ResponsesDAO responsesDAO;

	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView model) {
		Authenticate authenticate = new Authenticate();
		model.addObject("authenticate", authenticate);
		model.setViewName("index");

		return model;
	}

	@RequestMapping(value = "/adminPage")
	public ModelAndView adminModelAndView(ModelAndView adminPageModel) {
		List<Responses> responses = responsesDAO.list();
		adminPageModel.addObject("responses", responses);
		adminPageModel.setViewName("adminPage");

		return adminPageModel;
	}
	
	@RequestMapping(value = "/Chat")
	public ModelAndView ChatScreen(ModelAndView chatAndView) {
		chatAndView.setViewName("Chat");
		return chatAndView;
	}
	
	@RequestMapping(value = "/adminList")
	public ModelAndView adminListModelAndView(ModelAndView adminListModel) {
		List<Admin> admins = adminDAO.list();
		adminListModel.addObject("admins", admins);
		adminListModel.setViewName("adminList");

		return adminListModel;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newAdmin(ModelAndView model) {
		Admin admin = new Admin();
		model.addObject("admin", admin);
		model.setViewName("newAdmin");

		return model;
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView validateAdmin(@ModelAttribute Authenticate authenticate) {
		int result = adminDAO.verify(authenticate);
		if (result > 0)
			return new ModelAndView("redirect:adminPage");
		else

			return new ModelAndView("redirect:/");

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveAdmin(@ModelAttribute Admin admin) {
		adminDAO.save(admin);

		return new ModelAndView("redirect:/");
	}
}
