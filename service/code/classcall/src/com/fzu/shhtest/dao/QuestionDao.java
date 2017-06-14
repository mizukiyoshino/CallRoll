package com.fzu.shhtest.dao;

import java.util.Date;
import java.util.List;

import com.fzu.shhtest.domain.Question;

public interface QuestionDao {
	//Ôö
	int createQuestion(Question question);
	
	//É¾
	boolean deleteQuestionByCourseName(String cname);
	//boolean deleteQuestionByID(String ID);
	boolean deleteQuestionByCoursenameAndID(String cname,String ID);
	boolean deleteQuestionByCoursenameAndIDAndDate(String cname,String ID,Date date);
	
	//¸Ä
	//boolean updateQuestionByCourseName(Question question);
	//boolean updateQuestionByID(String ID);
	//boolean updateQuestionByCoursenameAndID(String cname,String ID);
	boolean updateQuestionByCoursenameAndIDAndDate(String cname,String ID,Date date);
	
	//²é
	List getAllQuestion();
	List getQuestionByCourseName(String cname);
	List getQuestionByID(String ID);
	List getQuestionByCoursenameAndID(String cname,String ID);
	List getQuestionByCoursenameAndIDAndDate(String cname,String ID,Date date);
}
