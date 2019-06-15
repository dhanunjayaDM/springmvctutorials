package com.jwt.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="questions")
public class Question 
{
	 @Id
	 @SequenceGenerator(name = "seq_contacts", sequenceName = "seq_contacts")
	 @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_contacts")
	 
	 private int QUESTION_ID; 
	 @Column private String QUESTION;
	 
	 @ManyToOne
	 @JoinColumn(name ="SURVEY_ID")
	 private Survey survey;
	 
	 @Transient
	 private List<String> answers;
	 
	 @Override
	  public String toString()
	  {
	   return ToStringBuilder.reflectionToString(this);
	  }
	 
	 public Question()
	 {
		 
	 }

	public Question(int qUESTION_ID, String qUESTION, Survey survey) {
		super();
		QUESTION_ID = qUESTION_ID;
		QUESTION = qUESTION;
		this.survey = survey;
	}

	public int getQUESTION_ID() {
		return QUESTION_ID;
	}

	public void setQUESTION_ID(int qUESTION_ID) {
		QUESTION_ID = qUESTION_ID;
	}

	public String getQUESTION() {
		return QUESTION;
	}

	public void setQUESTION(String qUESTION) {
		QUESTION = qUESTION;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	

	
	 
	
	 

}
