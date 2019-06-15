package com.mhi.model;

public class User 
{
	
	private String name;
	private String email;
	private Integer age;
	private String country;
	
//	public User(name,email,age,country)
//	{
//		this.name=name;
//		this.email=email;
//	    this.age=age;
//		this.country=country;
//	}
	
	
	public String getName() {
		return name;
	}
	
	public User(String name, String email, Integer age,String country) {

	this.name = name;
	this.email = email;
	this.age = age;
	this.country = country;
}

	public String getEmail() {
		return email;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public String getCountry() {
		return country;
	}
	
	
}
