package com.lara.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lara.beans.User;
import com.lara.dao.UserDao;

@Controller
public class RegitrationController {
	
	 @Autowired
	 UserDao userDao;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mav=new ModelAndView("register");
		return mav;
	}
	@RequestMapping(value="/registerProcess", method=RequestMethod.POST)
	public ModelAndView addUserdb(HttpServletRequest req, HttpServletResponse res, @ModelAttribute("user") User user)
	{
//		Random rnd = new Random();
//		int n = 100000 + rnd.nextInt(900000);
//		System.out.println("your otp for registeration :"+ n);
//		HttpSession session=req.getSession();
//		session.setAttribute("otp", n);
		userDao.register(user);
		return new ModelAndView("welcomeagain", "firstname", user.getFirstname());
	}

}
