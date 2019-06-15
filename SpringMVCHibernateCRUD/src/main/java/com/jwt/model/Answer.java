package com.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="answer")
public class Answer {
	 @Id
	 @SequenceGenerator(name = "seq_contacts", sequenceName = "seq_contacts")
	 @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_contacts")
	 private int Answer_ID;
	 
	 @Column 
	 private String answer;
	 
	 @ManyToOne
	 @JoinColumn(name ="Question_ID")
	 private Question question;
	 
	 public Answer(){
	  
	 }
	 
	 public Answer(int Answer_ID, String Answer, Question question )
	 {
	  super();
	  this.Answer_ID = Answer_ID;
	  this.answer = Answer;
	  this.question = question;
	 }

	public int getAnswer_ID() {
		return Answer_ID;
	}

	public void setAnswer_ID(int answer_ID) {
		Answer_ID = answer_ID;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	 
	 

}
