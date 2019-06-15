package com.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@Entity
//@Table(name="state")
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties({"state"})
@JsonPropertyOrder({"state","statePopulation"})
public class State 
{
//	@Id
//	@Column(name="state_name")
	@JsonProperty("state")
	private String stateName;
//	@Column(name="state_popupation")
	
	private long statePopulation;

	public State(){
		
	}

	public State(String stateName, long statePopulation) {
		super();
		this.stateName = stateName;
		this.statePopulation = statePopulation;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public long getStatePopulation() {
		return statePopulation;
	}

	public void setStatePopulation(long statePopulation) {
		this.statePopulation = statePopulation;
	}
	
	
	
}
