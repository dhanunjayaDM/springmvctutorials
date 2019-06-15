package com.mhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mhi.service.WelcomeService;

@Controller
public class WelcomeController {
	@Autowired
	private WelcomeService welcomeService;
	@RequestMapping(value="/welcome1",method=RequestMethod.GET)
	public ModelAndView welcome()
	{
		return new ModelAndView("welcome", "welcomeMessage", welcomeService.welcomeMessage());
	}
	@RequestMapping(value="/welcomeagain",method=RequestMethod.GET)
	public ModelAndView welcomeAgain() {
		return new ModelAndView("welcomeagain", "welcomeMessage", welcomeService.welcomeAgainMessage());
	}
	

}
