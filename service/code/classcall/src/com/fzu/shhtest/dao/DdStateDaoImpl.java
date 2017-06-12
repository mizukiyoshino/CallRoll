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
		// TODO Auto-generated method stub
		Session session = getSession();
		DdState ddState = getDdStateStateByName(dname);
		session.delete(ddState);
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
	public boolean updateDdStateStateByName(DdState ddState) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.update(ddState);
		return false;
	}

	@Override
	public List getAllDdState() {
		Session session = getSession();
		List list = session.createQuery("from DdState").list();
		return list;
	}
}
