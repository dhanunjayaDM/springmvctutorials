package com.jwt.utils;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jwt.model.Survey;

public class SurveyFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Survey.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object model, Errors errors) {
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "SURVEY_NAME","required.SURVEY_NAME", "survey name is required.");
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "START_DATE","required.START_DATE", "Start Date is required.");
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "END_DATE","required.END_DATE", "End Date is required.");
		  //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "QUESTION","required.QUESTION", "can not be blank.");
		  
		  /*ValidationUtils.rejectIfEmpty(errors, "START_DATE","required.SURVEY_NAME", "Enter date");*/
		
	}

}
