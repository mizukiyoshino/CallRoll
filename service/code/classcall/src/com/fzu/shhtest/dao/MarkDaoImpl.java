package com.fzu.shhtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.Mark;

public class MarkDaoImpl implements MarkDao {
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
	public int createMark(Mark mark) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.save(mark);
		return 0;
	}

	@Override
	public boolean deleteMarkByName(String cname) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<Mark> marks = getMarkByName(cname);
		for(Mark mark:marks)
		{
			session.delete(mark);
		}
		return false;
	}

	@Override
	public boolean updateMark(Mark mark) {
		Session session = getSession();
		session.update(mark);
		return false;
	}

	@Override
	public List getAllMark() {
		// TODO Auto-generated method stub
		Session session = getSession();
		List list = session.createQuery("from Mark").list();
		return list;
	}

	@Override
	public List getMarkByName(String cname) {
		Session session = getSession();
		Query query = session.createQuery("from Mark where courseName=?");
		query.setString(0, cname);
		List<Mark> list = (List<Mark>) query.list();
		if (list.size() > 0)
			return list;
		else
			return null;
	}

	@Override
	public List getMarkByID(String ID) {
		Session session = getSession();
		Query query = session.createQuery("from Mark where ID=?");
		query.setString(0, ID);
		List<Mark> list = (List<Mark>) query.list();
		if (list.size() > 0)
			return list;
		else
			return null;
	}

	@Override
	public Mark getMarkByNameAndID(String cname, String ID) {
		Session session = getSession();
		Query query = session.createQuery("from Mark where courseName=? and ID=?");
		query.setString(0, cname);
		query.setString(1, ID);
		List<Mark> list = (List<Mark>) query.list();
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
}
