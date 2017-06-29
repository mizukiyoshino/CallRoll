package com.fzu.shhtest.service;

import java.util.Date;
import java.util.List;

import com.fzu.shhtest.dao.QuestionDao;
import com.fzu.shhtest.domain.Question;

public class QuestionServiceImpl implements QuestionService {
	private QuestionDao questionDao;
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	@Override
	public int createQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionDao.createQuestion(question);
	}

	@Override
	public boolean deleteQuestionByCourseName(String cname) {
		// TODO Auto-generated method stub
		return questionDao.deleteQuestionByCourseName(cname);
	}
	/*
	@Override
	public boolean updateQuestionByCourseName(Question question) {
		// TODO Auto-generated method stub
		return questionDao.updateQuestionByCourseName(question);
	}
	*/
	@Override
	public List getAllQuestion() {
		// TODO Auto-generated method stub
		return questionDao.getAllQuestion();
	}

	@Override
	public List getQuestionByCourseName(String cname) {
		// TODO Auto-generated method stub
		return questionDao.getQuestionByCourseName(cname);
	}

	@Override
	public List getQuestionByID(String ID) {
		// TODO Auto-generated method stub
		return questionDao.getQuestionByID(ID);
	}

	@Override
	public List getQuestionByCoursenameAndID(String cname,String ID) {
		// TODO Auto-generated method stub
		return questionDao.getQuestionByCoursenameAndID(cname,ID);
	}

	@Override
	public List getQuestionByCoursenameAndIDAndDate(String cname,String ID,Date date) {
		// TODO Auto-generated method stub
		return questionDao.getQuestionByCoursenameAndIDAndDate(cname,ID,date);
	}

	

	@Override
	public boolean deleteQuestionByCoursenameAndID(String cname, String ID) {
		// TODO Auto-generated method stub
		return questionDao.deleteQuestionByCoursenameAndID(cname, ID);
	}

	@Override
	public boolean deleteQuestionByCoursenameAndIDAndDate(String cname,
			String ID, Date date) {
		// TODO Auto-generated method stub
		return questionDao.deleteQuestionByCoursenameAndIDAndDate(cname, ID, date);
	}
	
	/*
	@Override
	public boolean deleteQuestionByID(String ID) {
		// TODO Auto-generated method stub
		return questionDao.deleteQuestionByID(ID);
	}
	@Override
	public boolean updateQuestionByID(String ID) {
		// TODO Auto-generated method stub
		return questionDao.updateQuestionByID(ID);
	}

	@Override
	public boolean updateQuestionByCoursenameAndID(String cname, String ID) {
		// TODO Auto-generated method stub
		return questionDao.updateQuestionByCoursenameAndID(cname, ID);
	}
	*/
	
	@Override
	public boolean updateQuestionByCoursenameAndIDAndDate(String cname,
			String ID, Date date) {
		// TODO Auto-generated method stub
		return questionDao.updateQuestionByCoursenameAndIDAndDate(cname, ID, date);
	}
}
