package com.fzu.shhtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fzu.shhtest.domain.Personnel;

public class PersonnelDaoImpl implements PersonnelDao {
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
	public int createPersonnel(Personnel personnel) {
		Session session = getSession();
		session.save(personnel);
		return 0;
	}

	@Override
	public boolean deletePersonnelByName(String sname) {
		Personnel personnel = getPersonnelByID(sname);
		Session session = getSession();
		session.delete(personnel);
		return false;
	}
	
	@Override
	public boolean deletePersonnelByID(String id) {
		Personnel personnel = getPersonnelByID(id);
		Session session = getSession();
		session.delete(personnel);
		return false;
	}

	@Override
	public boolean updatePersonnel(Personnel personnel) {
		Session session = getSession();
		try {
			session.update(personnel);
		} catch (IllegalStateException e) {
			System.out.println(e.toString());
		}
		return false;
	}

	@Override
	public List getAllPersonnel() {
		Session session = getSession();
		List list = session.createQuery("from Personnel").list();
		return list;
	}

	@Override
	public Personnel getPersonnelByName(String pname) {
		Session session = getSession();
		Query query = session.createQuery("from Personnel where Pname=?");
		query.setString(0, pname);
		List<Personnel> list = (List<Personnel>) query.list();
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	
	@Override
	public List getPersonnelByNameHql(String pname) {
		Session session = getSession();
		String hqlString = "SELECT ID,Ppassword,Pname,dm.dname AS major,dr.dname AS role ,pclass FROM personnel p,ddmajor dm ,ddrole dr WHERE p.major=dm.major AND p.role=dr.role AND p.Pname=\'";
		hqlString = hqlString+pname+"\'";
		Query query = session.createSQLQuery(hqlString);
		List list = query.list();
		return list;
	}

	
	@Override
	public Personnel getPersonnelByID(String ID) {
		Session session = getSession();
		Query query = session.createQuery("from Personnel where ID=?");
		query.setString(0, ID);
		List<Personnel> list = (List<Personnel>) query.list();
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	
	
	@Override
	public List getPersonnelByIDHql(String ID) {
		Session session = getSession();
		String hqlString = "SELECT ID,Ppassword,Pname,dm.dname AS major,dr.dname AS role ,pclass FROM personnel p,ddmajor dm ,ddrole dr WHERE p.major=dm.major AND p.role=dr.role AND ID=";
		hqlString = hqlString+ID;
		Query query = session.createSQLQuery(hqlString);
		System.out.println(query.list());
		List list = query.list();
		return list;
	}

	@Override
	public List getAllPersonnelHql() {
		Session session = getSession();
		String hqlString = "SELECT ID,Ppassword,Pname,dm.dname AS major,dr.dname AS role ,pclass FROM personnel p,ddmajor dm ,ddrole dr WHERE p.major=dm.major AND p.role=dr.role;";
		Query query = session.createSQLQuery(hqlString);
		List list = query.list();
		return list;
	}
}
