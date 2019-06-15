package com.mhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping(value = "/hi",method = RequestMethod.GET)
    @ResponseBody
	public String welcome() {
		return "home";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome23() {
		return new ModelAndView("about", "mymessage", "welcome to spring mvc");
	}

}
