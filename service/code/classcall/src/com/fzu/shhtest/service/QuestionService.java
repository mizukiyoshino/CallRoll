package com.fzu.shhtest.service;

import java.util.Date;
import java.util.List;

import com.fzu.shhtest.domain.Question;

public interface QuestionService {
	int createQuestion(Question question);
	boolean deleteQuestionByCourseName(String cname);
	//boolean deleteQuestionByID(String ID);
	boolean deleteQuestionByCoursenameAndID(String cname,String ID);
	boolean deleteQuestionByCoursenameAndIDAndDate(String cname,String ID,Date date);
	
	//boolean updateQuestionByCourseName(Question question);
	//boolean updateQuestionByID(String ID);
	//boolean updateQuestionByCoursenameAndID(String cname,String ID);
	boolean updateQuestionByCoursenameAndIDAndDate(String cname,String ID,Date date);
	
	List getAllQuestion();
	List getQuestionByCourseName(String cname);
	List getQuestionByID(String ID);
	List getQuestionByCoursenameAndID(String cname,String ID);
	List getQuestionByCoursenameAndIDAndDate(String cname,String ID,Date date);
}
