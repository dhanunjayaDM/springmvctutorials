package com.dineshonjava.survey.dao;

import java.util.List;

import com.dineshonjava.survey.bean.Answer;

/**
 * @author Dinesh Rajput
 *
 */
public interface AnswerDAO {
	Answer getByAnswer_ID(int Answer_ID);
	
	List<Answer> getAllAnswer();
	
	int save(Answer answer);
	
	void update(Answer answer);
	
	void view(Answer answer);
	
	void delete(int Answer_ID);
}
