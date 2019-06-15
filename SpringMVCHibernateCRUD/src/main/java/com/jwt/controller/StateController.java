package com.jwt.controller;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.State;

@RestController
public class StateController 
{
	
	//============================ Retrieving all states records =====================
	
	//@ResponseBody
	@RequestMapping(value="/states",method=RequestMethod.GET)
	public ArrayList<State> getStateList()
	{
		State s=new State();
		s.setStateName("AP");
		s.setStatePopulation(10000);
		
		State s1=new State();
		s1.setStateName("AcP");
		s1.setStatePopulation(10100);
		
		State s2=new State();
		s2.setStateName("Kr");
		s2.setStatePopulation(10200);
		
		State s3=new State();
		s3.setStateName("MP");
		s3.setStatePopulation(10300);
		
		ArrayList<State> statelist=new ArrayList<State>();
		statelist.add(s);
		statelist.add(s1);
		statelist.add(s2);
		statelist.add(s3);
		
		return statelist;
	}
	//============================ Retrieving  specified state  record =====================
	
	//@ResponseBody
	@RequestMapping(value="/states/{name}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public State getState(@PathVariable("name")String name)
	{
		State s=new State();
		s.setStateName(name);
		s.setStatePopulation(10000);
		return s;
	}
	
	@RequestMapping(value="/states/{name}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean updateState(@PathVariable("name") String name,@RequestBody State s)
	{
		System.out.println("State Name :"+ name);
		System.out.println("State Name :"+ s.getStateName()+"State Population: "+ s.getStatePopulation());
		return true;
	}


}
