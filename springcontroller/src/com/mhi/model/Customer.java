package com.mhi.model;

public class Customer {
	private String name;
	private String email;
	private Integer age;
	private String country;
	public Customer()
	{
		
	}
	public Customer(String name, String email, Integer age, String country) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.country = country;
	}
	public String getName() {
		return name;
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
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
