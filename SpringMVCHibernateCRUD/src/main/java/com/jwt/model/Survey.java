package com.jwt.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name="Survey")
public class Survey 
{
	 @Id
	 @SequenceGenerator(name = "seq_contacts", sequenceName = "seq_contacts")
	 @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_contacts") 
	 private int SURVEY_ID; 
	 
	 @Column 
	 private String SURVEY_NAME;
	 @Column 
	 private Date START_DATE; 
	 @Column 
	 private Date END_DATE;
	 @Column 
	 private String STATUS;
	 

	@Transient
	private List<Question> questions;
	
	@Transient
	private List<String> Answer;
	
	

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<String> getAnswer() {
		return Answer;
	}

	public void setAnswer(List<String> answer) {
		Answer = answer;
	}

	public Survey()
	 {}
	 
	public Survey(int sURVEY_ID, String sURVEY_NAME, Date sTART_DATE, Date eND_DATE, String sTATUS) {
		super();
		SURVEY_ID = sURVEY_ID;
		SURVEY_NAME = sURVEY_NAME;
		START_DATE = sTART_DATE;
		END_DATE = eND_DATE;
		STATUS = sTATUS;
	}
	public int getSURVEY_ID() {
		return SURVEY_ID;
	}
	public void setSURVEY_ID(int sURVEY_ID) {
		SURVEY_ID = sURVEY_ID;
	}
	public String getSURVEY_NAME() {
		return SURVEY_NAME;
	}
	public void setSURVEY_NAME(String sURVEY_NAME) {
		SURVEY_NAME = sURVEY_NAME;
	}
	public Date getSTART_DATE() {
		return START_DATE;
	}
	public void setSTART_DATE(Date sTART_DATE) {
		START_DATE = sTART_DATE;
	}
	public Date getEND_DATE() {
		return END_DATE;
	}
	public void setEND_DATE(Date eND_DATE) {
		END_DATE = eND_DATE;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	 
	 @Override
	 public String toString()
	 {
	  return ToStringBuilder.reflectionToString(this);
	 }


//	public List<String> getAnswer() {
//		return Answer;
//	}
//
//	public void setAnswer(List<String> answer) {
//		Answer = answer;
//	}
	 
 
	 
}
