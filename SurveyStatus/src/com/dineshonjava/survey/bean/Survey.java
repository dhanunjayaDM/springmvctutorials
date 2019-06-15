package com.dineshonjava.survey.bean;

/**
 * @author Dinesh Rajput
 *
 */
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
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
	private List<String> QUESTION;
	@Transient
	private List<String> Answer;
	
	public Survey()
	{}
	public Survey(int SURVEY_ID, String SURVEY_NAME, Date START_DATE, Date END_DATE, String STATUS)
	{
		super();
		this.SURVEY_ID = SURVEY_ID;
		this.SURVEY_NAME = SURVEY_NAME;
		this.START_DATE = START_DATE;
		this.END_DATE = END_DATE;
		this.STATUS = STATUS;
		
	}
	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
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
	public List<String> getQUESTION() {
		return QUESTION;
	}
	public void setQUESTION(List<String> qUESTION) {
		QUESTION = qUESTION;
	}
	public List<String> getAnswer() {
		return Answer;
	}
	public void setAnswer(List<String> answer) {
		Answer = answer;
	}
	
}

