package com.mhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mhi.model.User;
@Controller
public class UserController 
{
	@RequestMapping(value="/listUsers")
	public ModelAndView listUsers() {
		return new ModelAndView("listUsers", "listUserMessage", "List of Users returned");
	}
//	@RequestMapping(value="/saveUser")
//	public ModelAndView saveUser(User user)
//	{
//		return new ModelAndView("saveUser","saveUserMessage", "User data is saved");
//	}
//	@RequestMapping(value="/deleteUser")
//	public ModelAndView deleteUser(User user)
//	{
//		return new ModelAndView("deleteUser","deleteUserMessage", "User data is deleted");
//	}

}
