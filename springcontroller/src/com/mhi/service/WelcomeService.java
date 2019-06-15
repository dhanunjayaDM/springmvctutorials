package com.mhi.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

	public String welcomeMessage() 
	{
		return "welcome to spring MVC world!!!";
	}
	
	public Object welcomeAgainMessage() 
	{
		return "welcome to spring mvc world again !!!";
	}
}
