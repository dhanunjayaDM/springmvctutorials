package com.jwt.dao;

import java.util.List;

import com.jwt.model.Survey;

public interface SurveyDao {
	
	 Survey getBySURVEY_ID(int SURVEY_ID);
	 
	 List<Survey> getAllSurvey();
	 
	 int save(Survey survey);
	 
	 void update(Survey survey);
	 
	 void view(Survey survey);
	 
	 void delete(int SURVEY_ID);

}
