package com.fzu.shhtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fzu.shhtest.domain.DdMajor;
import com.fzu.shhtest.domain.DdRole;

public class DdMajorDaoImpl implements DdMajorDao {
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
	public int createDdMajor(DdMajor ddMajor) {
		Session session = getSession();
		session.save(ddMajor);
		return 0;
	}

	@Override
	public boolean deleteDdMajorByName(String dname) {
		Session session = getSession();
		String hqlString = "DELETE FROM DdMajor WHERE dname=?";
		Query query = session.createSQLQuery(hqlString);
		query.setString(0,dname);
		query.executeUpdate();
		return false;
	}

	@Override
	public DdMajor getDdMajorStateByName(String dname) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("from DdMajor where dname=?");
		query.setString(0, dname);
		List<DdMajor> list = (List<DdMajor>) query.list();
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public boolean updateDdMajorStateByName(DdMajor ddMajor,String oldDname) {		
		Session session = getSession();
		String hqlString = "UPDATE ddmajor SET major=?,dname=?,state=? WHERE dname=?";
		
		Query query = session.createSQLQuery(hqlString);
		query.setInteger(0, ddMajor.getMajor());
		query.setString(1, ddMajor.getDname());
		query.setString(2, ddMajor.getState());
		query.setString(3, oldDname);
		query.executeUpdate();
		return false;
	}

	@Override
	public List getAllDdMajor() {
		Session session = getSession();
		List list = session.createQuery("from DdMajor").list();
		return list;
	}
}
