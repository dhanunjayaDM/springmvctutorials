package com.mhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MultipleController 
{
	@RequestMapping(value= {"/hello","/hai","/"},method=RequestMethod.GET)
	public ModelAndView multicontroller()
	{
		return new ModelAndView("multicontroller", "multiControllerMessgae", "welcome to multicontroller same action");
	}

}
