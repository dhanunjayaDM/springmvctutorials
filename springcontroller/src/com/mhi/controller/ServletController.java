package com.mhi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mhi.model.User;

@Controller
public class ServletController {
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerPage() 
	{
		return "register";
	}
	
	@RequestMapping(value="/registersuccess",method=RequestMethod.POST)
	public ModelAndView servlet(HttpServletRequest req,HttpServletResponse res)
	{
		String username=req.getParameter("name");
		String email=req.getParameter("email");
		String country=req.getParameter("country");
		int age=Integer.parseInt(req.getParameter("age"));
		User user=new User(username,email,age,country);
		ModelAndView mav=new ModelAndView("registersuccess");
		mav.addObject("user",user);
		return mav;
	}

}
