package com.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CREDIT_CARD")
public class CreditCard {
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="NUMBER")
	private String number;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
	
	
	
	
}
