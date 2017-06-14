package com.fzu.shhtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fzu.shhtest.domain.DdClassDate;
import com.fzu.shhtest.domain.DdState;

public class DdStateDaoImpl implements DdStateDao {
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
	public int createDdState(DdState ddState) {
		Session session = getSession();
		session.save(ddState);
		return 0;
	}

	@Override
	public boolean deleteDdStateByName(String dname) {
		Session session = getSession();
		String hqlString = "DELETE FROM DdState WHERE dname=?";
		Query query = session.createSQLQuery(hqlString);
		query.setString(0,dname);
		query.executeUpdate();
		return false;
	}

	@Override
	public DdState getDdStateStateByName(String dname) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("from DdState where dname=?");
		query.setString(0, dname);
		List<DdState> list = (List<DdState>) query.list();
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public boolean updateDdStateStateByName(DdState ddState,String oldDname) {
		Session session = getSession();
		String hqlString = "UPDATE DdState SET callstate=?,dname=?,state=? WHERE dname=?";
		
		Query query = session.createSQLQuery(hqlString);
		query.setInteger(0, ddState.getCallstate());
		query.setString(1, ddState.getDname());
		query.setString(2, ddState.getState());
		query.setString(3, oldDname);

		query.executeUpdate();
		return false;
	}

	@Override
	public List getAllDdState() {
		Session session = getSession();
		List list = session.createQuery("from DdState").list();
		return list;
	}
}
