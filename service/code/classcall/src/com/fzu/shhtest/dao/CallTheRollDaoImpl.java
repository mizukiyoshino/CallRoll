package com.fzu.shhtest.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fzu.shhtest.domain.CallTheRoll;
import com.fzu.shhtest.domain.Personnel;

public class CallTheRollDaoImpl implements CallTheRollDao {
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
	public int createCallTheRoll(CallTheRoll callTheRoll) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.save(callTheRoll);
		return 0;
	}

	@Override
	public boolean deleteCallTheRollByID(String ID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<CallTheRoll> callTheRolls = getCallTheRollByID(ID);
		for(CallTheRoll callTheRoll:callTheRolls)
		{
			session.delete(callTheRoll);
		}
		return false;
	}

	@Override
	public boolean updateCallTheRoll(CallTheRoll callTheRoll) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.update(callTheRoll);
		return false;
	}

	@Override
	public List getAllCallTheRoll() {
		Session session = getSession();
		List list = session.createQuery("from CallTheRoll").list();
		return list;
	}

	@Override
	public List getCallTheRollByDate(Date date) {
		Session session = getSession();
		Query query = session.createQuery("from CallTheRoll where calldate=?");
		query.setDate(0, date);
		List<CallTheRoll> list = (List<CallTheRoll>) query.list();
		return list;
	}

	@Override
	public List getCallTheRollBetweenDate(Date date1, Date date2) {
		Session session = getSession();
		Query query = session.createQuery("from CallTheRoll where calldate>=? and calldate<=?");
		query.setDate(0, date1);
		query.setDate(1, date2);
		List<CallTheRoll> list = (List<CallTheRoll>) query.list();
		return list;
	}

	@Override
	public List getCallTheRollByID(String ID) {
		Session session = getSession();
		Query query = session.createQuery("from CallTheRoll where ID=?");
		query.setString(0, ID);
		List<CallTheRoll> list = (List<CallTheRoll>) query.list();
		return list;
	}

	@Override
	public List getCallTheRollByCoursename(String cname) {
		Session session = getSession();
		Query query = session.createQuery("from CallTheRoll where courseName=?");
		query.setString(0, cname);
		List<CallTheRoll> list = (List<CallTheRoll>) query.list();
		return list;
	}
}
