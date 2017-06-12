package com.fzu.shhtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fzu.shhtest.domain.Personnel;
import com.fzu.shhtest.domain.SchoolInfo;

public class SchoolInfoDaoImpl implements SchoolInfoDao {
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
	public int createSchoolInfo(SchoolInfo schoolInfo) {
		Session session = getSession();
		session.save(schoolInfo);
		return 0;
	}

	@Override
	public boolean deleteSchoolInfo() {
		SchoolInfo schoolInfo = getSchoolInfo();
		Session session = getSession();
		session.delete(schoolInfo);
		return false;
	}

	@Override
	public boolean updateSchoolInfo(SchoolInfo schoolInfo) {
		Session session = getSession();
		try {
			session.update(schoolInfo);
		} catch (IllegalStateException e) {
			System.out.println(e.toString());
		}
		return false;
	}

	@Override
	public SchoolInfo getSchoolInfo() {
		Session session = getSession();
		Query query = session.createQuery("from SchoolInfo");
		List<SchoolInfo> list = (List<SchoolInfo>) query.list();
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
}
