package com.jwt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Employee;
import com.jwt.model.Employer;
import com.jwt.service.EmployeeService;
import com.jwt.service.EmployerService;

@Controller
public class RelationalController 
{
	@Autowired
	private EmployerService employerService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value= "/relational")
	public ModelAndView relational(ModelAndView mav)
	{
		List<Employee> listEmployee=employeeService.getAllEmployees();
		mav.addObject("listEmployee", listEmployee);
		mav.addObject("employer", new Employer());
		mav.setViewName("countrystate");
		return mav;
	}
	@RequestMapping(value= "/relationalProcess")
	public ModelAndView relationalprcvocess(@ModelAttribute("employer") Employer employer,ModelAndView mav,HttpServletRequest req)
	{
		
//		Employer employer=new Empl
		employerService.addEmployeer(employer);
		System.out.println("concomplate");
		mav.setViewName("redirect:/relational");
		return mav;
	}
	@RequestMapping(value= "/hi")
	public String hi()
	{
		return "hi";
	}

}
