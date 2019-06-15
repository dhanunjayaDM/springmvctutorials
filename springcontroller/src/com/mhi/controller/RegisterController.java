//package com.mhi.controller;
//
//import java.util.Map;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.mhi.model.User;
//
//@Controller
//public class RegisterController 
//{
//	@RequestMapping(value="/register",method=RequestMethod.GET)
//	public String registerPage() 
//	{
//		return "register";
//	}
////	@RequestMapping(value="/registersuccess",method=RequestMethod.POST)
////	public ModelAndView registerSuccess(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("age") int age,@RequestParam("country") String country) {
////		 User user=new User(name,email,age,country);
////		 ModelAndView modelandview=new ModelAndView("registersuccess");
////		 modelandview.addObject("user",user);
////		 return modelandview;
////		
////	}
////	
//	@RequestMapping(value="/registersuccess",method=RequestMethod.POST)
//	public ModelAndView registerSuccess(@RequestParam Map<String,String> requestMap) {
//		 User user=new User(requestMap.get("name"),requestMap.get("email"),Integer.parseInt(requestMap.get("age")),requestMap.get("country"));
//		 ModelAndView modelandview=new ModelAndView("registersuccess");
//		 modelandview.addObject("user",user);
//		 return modelandview;
//		
//	}
//
//
//}
