package com.fzu.shhtest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fzu.shhtest.domain.Personnel;
import com.fzu.shhtest.domain.Question;

public class QuestionDaoImpl implements QuestionDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		if (sessionFactory == null)
			return null;
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int createQuestion(Question question) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.save(question);
		return 0;
	}

	@Override
	public boolean deleteQuestionByCourseName(String cname) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<Question> questions = getQuestionByCourseName(cname);
		if (questions != null) {
			for (Question question : questions) {
				session.delete(question);
			}
		}
		return false;
	}

	/*
	 * @Override public boolean deleteQuestionByID(String ID) { // TODO
	 * Auto-generated method stub Session session = getSession(); List<Question>
	 * questions = getQuestionByID(ID); for(Question question:questions) {
	 * session.delete(question); } return false; }
	 */
	@Override
	public boolean deleteQuestionByCoursenameAndID(String cname, String ID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<Question> questions = getQuestionByCoursenameAndID(cname, ID);
		if (questions != null) {
			for (Question question : questions) {
				session.delete(question);
			}
		}
		return false;
	}

	@Override
	public boolean deleteQuestionByCoursenameAndIDAndDate(String cname,
			String ID, Date date) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<Question> questions = getQuestionByCoursenameAndIDAndDate(cname,
				ID, date);
		if (questions != null) {
			for (Question question : questions) {
				session.delete(question);
			}
		}
		return false;
	}

	/*
	 * @Override public boolean updateQuestionByCourseName(Question question) {
	 * // TODO Auto-generated method stub Session session = getSession();
	 * session.update(question); return false; }
	 * 
	 * @Override public boolean updateQuestionByID(String ID) { // TODO
	 * Auto-generated method stub Session session = getSession(); List<Question>
	 * questions = getQuestionByID(ID); for(Question question:questions) {
	 * session.update(question); } return false; }
	 * 
	 * @Override public boolean updateQuestionByCoursenameAndID(String cname,
	 * String ID) { // TODO Auto-generated method stub Session session =
	 * getSession(); List<Question> questions =
	 * getQuestionByCoursenameAndID(cname, ID); for(Question question:questions)
	 * { session.update(question); } return false; }
	 */
	@Override
	public boolean updateQuestionByCoursenameAndIDAndDate(String cname,
			String ID, Date date) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<Question> questions = (ArrayList<Question>)getQuestionByCoursenameAndIDAndDate(cname,
				ID, date);
		session.update(questions.get(0));
		return false;
	}

	@Override
	public List getAllQuestion() {
		Session session = getSession();
		List list = session.createQuery("from Question").list();
		return list;
	}

	@Override
	public List getQuestionByCourseName(String cname) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("from Question where courseName=?");
		query.setString(0, cname);
		List<Question> list = (List<Question>) query.list();
		System.out.println("list.size()   " + list.size());
		return list;
	}

	@Override
	public List getQuestionByID(String ID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("from Question where ID=?");
		query.setString(0, ID);
		List<Question> list = (List<Question>) query.list();
		return list;
	}

	@Override
	public List getQuestionByCoursenameAndID(String cname, String ID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session
				.createQuery("from Question where courseName=? and ID=?");
		query.setString(0, cname);
		query.setString(1, ID);
		List<Question> list = (List<Question>) query.list();
		System.out.println("list.size()   " + list.size());
		return list;
	}

	@Override
	public List getQuestionByCoursenameAndIDAndDate(String cname, String ID,
			Date date) {
		Session session = getSession();
		Query query = session
				.createQuery("from Question where courseName=? and ID=? and attendanceDate=?");
		query.setString(0, cname);
		query.setString(1, ID);
		query.setDate(2, date);
		List<Question> list = (List<Question>) query.list();
		if (list.size() > 0)
			return list;
		else
			return null;
	}
}
