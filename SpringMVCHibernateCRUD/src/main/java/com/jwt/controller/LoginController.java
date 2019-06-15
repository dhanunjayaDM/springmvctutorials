package com.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Login;
import com.jwt.model.UserRegistration;
import com.jwt.service.UserRegistrationService;

@Controller
public class LoginController {
	
	@Autowired
	private UserRegistrationService userRegistrationService;
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin() 
	 {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new Login());
	    return mav;
	  }
	 
	  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(@ModelAttribute("login") Login login) {
	    ModelAndView mav = null;
	    System.out.println("logincontroller");
	    UserRegistration user=userRegistrationService.validateUser(login);
	    System.out.println(user);
	    if (null != user) {
	    mav = new ModelAndView("welcome");
	    mav.addObject("firstname", user.getName());
	    } else {
	    mav = new ModelAndView("login");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }

}
