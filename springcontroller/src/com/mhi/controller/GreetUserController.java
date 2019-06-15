package com.mhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetUserController 
{
//	@RequestMapping(value="/user/{userName}/{age}",method=RequestMethod.GET)
//	public ModelAndView greet(@PathVariable("userName") String userName,@PathVariable("age") int age)
//	{
//		return new ModelAndView("greet","greetMessage","Hello " +userName +" you are " +age +" years old");
//	}
	
	@RequestMapping(value="/user/{userName}/{age}",method=RequestMethod.GET)
	public ModelAndView greetmsg(@PathVariable("userName") String userName,@PathVariable("age") int age,@RequestParam("country") String country)
	{
		return new ModelAndView("greet","greetMessage","Hello " +userName +" you are " +age +" years old. and you are from "+ country);
	}

}
