package com.jwt.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.jwt.model.UserRegistration;
import com.jwt.service.UserRegistrationService;


@Controller
public class UserRegistrationController {
	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@RequestMapping(value = "/register")
	public ModelAndView showregister(ModelAndView model) throws IOException {
		//List<Employee> listEmployee = employeeService.getAllEmployees();
		model.addObject("userRegistration", new UserRegistration());
		model.setViewName("register");
		return model;
	}
	
	@RequestMapping(value = "/registersuccess",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("userRegistration") UserRegistration userRegistration,ModelAndView model) throws IOException {
		//List<Employee> listEmployee = employeeService.getAllEmployees();
		userRegistrationService.addUser(userRegistration);
		model.addObject("userRegistration", "Registration is Successfull");
		model.setViewName("registersuccess");
		return model;
	}

}
