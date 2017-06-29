package com.fzu.shhtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.DdRole;

public class DdRoleDaoImpl implements DdRoleDao {
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
	public int createDdRole(DdRole ddRole) {
		Session session = getSession();
		session.save(ddRole);
		return 0;
	}

	@Override
	public boolean deleteDdRoleByName(String dname) {
		// TODO Auto-generated method stub
		Session session = getSession();
		DdRole ddRole = getDdRoleStateByName(dname);
		session.delete(ddRole);
		return false;
	}

	@Override
	public boolean updateDdRoleStateByName(DdRole ddRole) {
		Session session = getSession();
		session.update(ddRole);
		return false;
	}

	@Override
	public List getAllDdRole() {
		Session session = getSession();
		List list = session.createQuery("from DdRole").list();
		return list;
	}

	@Override
	public DdRole getDdRoleStateByName(String dname) {
		Session session = getSession();
		Query query = session.createQuery("from DdRole where dname=?");
		query.setString(0, dname);
		List<DdRole> list = (List<DdRole>) query.list();
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
}
