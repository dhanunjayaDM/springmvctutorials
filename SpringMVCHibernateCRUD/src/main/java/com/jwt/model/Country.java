//package com.jwt.model;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinTable;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.persistence.JoinColumn;
//
//
//
//@Entity
//@Table(name="country")
//public class Country {
//	@Id
//	@Column(name="country_name")
//	private String countryName;
//	
//	@Column(name="country_population")
//	private long countryPopulation;
//	
//    @OneToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="country_state",joinColumns={@JoinColumn(name="country_name")},
//	inverseJoinColumns={@JoinColumn(name="state_name")})
//	List<State> listOfStates=new ArrayList();
//	
//	
//	public Country(){
//		
//	}
//
//	public Country(String countryName, long countryPopulation) {
//		super();
//		this.countryName = countryName;
//		this.countryPopulation = countryPopulation;
//	}
//
//	public String getCountryName() {
//		return countryName;
//	}
//
//	public void setCountryName(String countryName) {
//		this.countryName = countryName;
//	}
//
//	public long getCountryPopulation() {
//		return countryPopulation;
//	}
//
//	public void setCountryPopulation(long countryPopulation) {
//		this.countryPopulation = countryPopulation;
//	}
//
//    public List getListOfStates() {
//		return listOfStates;
//	}
//
//	public void setListOfStates(List listOfStates) {
//		this.listOfStates = listOfStates;
//	}
//
//
//	
//	
//
//}
