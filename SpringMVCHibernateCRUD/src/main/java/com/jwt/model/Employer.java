package com.jwt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "EMPER_TBL")
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	
	@Column
	private String ename;
	
	public Employer()
	{
		
	}
	
//	public Employer(String ename, Employee employee) {
//		super();
//		this.ename = ename;
//		this.employee = employee;
//	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id", nullable = false)
	private Employee employee;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	


}
