package com.dineshonjava.survey.dao;

import java.util.List;

import com.dineshonjava.survey.bean.Question;

/**
 * @author Dinesh Rajput
 *
 */
public interface QuestionDAO {
	Question getByQuestion_ID(int Question_ID);
	
	List<Question> getAllQuestion();
	
	int save(Question question);
	
	void update(Question question);
	
	void view(Question question);
	
	void delete(int Question_ID);
}
