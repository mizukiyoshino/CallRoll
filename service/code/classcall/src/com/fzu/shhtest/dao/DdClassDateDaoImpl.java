package com.fzu.shhtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fzu.shhtest.domain.DdClassDate;
import com.fzu.shhtest.domain.DdRole;
import com.fzu.shhtest.domain.DdState;

public class DdClassDateDaoImpl implements DdClassDateDao {
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
	public int createDdClassDate(DdClassDate ddClassDate) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.save(ddClassDate);
		return 0;
	}

	@Override
	public boolean deleteDdClassDateByName(String dname) {
		Session session = getSession();
		String hqlString = "DELETE FROM DdClassDate WHERE dname=?";
		Query query = session.createSQLQuery(hqlString);
		query.setString(0,dname);
		query.executeUpdate();
		return false;
	}

	@Override
	public DdClassDate getDdClassDateStateByName(String dname) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("from DdClassDate where dname=?");
		query.setString(0, dname);
		List<DdClassDate> list = (List<DdClassDate>) query.list();
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	@Override
	public DdClassDate getDdClassDateStateByValue(int value){
		Session session = getSession();
		Query query = session.createQuery("from DdClassDate where classDate=?");
		query.setInteger(0, value);
		List<DdClassDate> list = (List<DdClassDate>) query.list();
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public boolean updateDdClassDateStateByName(DdClassDate ddClassDate,String oldDname) {
		Session session = getSession();
		String hqlString = "UPDATE DdClassDate SET classDate=?,dname=?,state=? WHERE dname=?";
		
		Query query = session.createSQLQuery(hqlString);
		query.setInteger(0, ddClassDate.getClassDate());
		query.setString(1, ddClassDate.getDname());
		query.setString(2, ddClassDate.getState());
		query.setString(3, oldDname);

		query.executeUpdate();
		return false;
	}
	
	@Override
	public List getAllDdClassDate() {
		Session session = getSession();
		List list = session.createQuery("from DdClassDate").list();
		return list;
	}
}
