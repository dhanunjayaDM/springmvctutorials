package com.mhi.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StringController {
	//case-1
	@RequestMapping(value="/str")
	public String strpage(Model model)
	{
		model.addAttribute("strMessage", "welcome  to www.infotech.net");
		model.addAttribute("headerMessage", "welcome to infotech");
		return "strpage";
	}
	//case-2
	@RequestMapping(value="/strpage")
	public String strpage2(Map<String, Object> map)
	{
		map.put("strMessage", "welcome  to www.infotech.net");
		map.put("headerMessage", "welcome to infotech");
		return "strpage2";
	}
	//case-3
	@RequestMapping(value="/strpattern")
	public String strpage3()
	{
		return "strpage3";
	}
	@ModelAttribute
	public void modelData(Model model)
	{
		model.addAttribute("strMessage", "welcome  to www.infotech.net");
		model.addAttribute("headerMessage", "welcome to infotech");
	}



}
