package com.mhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mhi.model.Customer;
import com.mhi.service.CustomerService;

@Controller
public class CustomerController 
{
//	@Autowired
//	private CustomerService customerService;
//	
//	@RequestMapping(value="/listcustomers",method=RequestMethod.GET)
//	public ModelAndView customerlist(ModelAndView modelandview)
//	{
//		modelandview.setViewName("customerlist");
//		List<Customer> customerlist=customerService.getCustomerList();
//	    modelandview.addObject("customerlist",customerlist);
//		return modelandview;
//	}
	
	@Autowired
	private CustomerService customerService;
	@RequestMapping(value="/addcustomer",method=RequestMethod.GET)
	public String customerregister()
	{
		return "cusregister";
	}
	
//	@RequestMapping(value="/customersuccess",method=RequestMethod.POST)
//     public String registerSuccess(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("age") int age,@RequestParam("country") String country) {
//	 Customer customer=new Customer(name,email,age,country);
//	 customerService.createUser(customer);
//	 return "redirect:/listcustomers";
//	 }

	
	@RequestMapping(value="/customersuccess",method=RequestMethod.POST)
    public String registerSuccess(@ModelAttribute("customer") Customer customer) {
	 customerService.createUser(customer);
	 return "redirect:/listcustomers";
	 }

	@RequestMapping(value="/listcustomers",method=RequestMethod.GET)
	public ModelAndView customerlist(ModelAndView modelandview)
	{
		modelandview.setViewName("customerlist");
		List<Customer> customerlist=customerService.getCustomerList();
	    modelandview.addObject("customerlist",customerlist);
		return modelandview;
	}

}
