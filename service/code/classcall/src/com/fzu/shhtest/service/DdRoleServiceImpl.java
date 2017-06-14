package com.fzu.shhtest.service;

import java.util.List;

import com.fzu.shhtest.dao.CourseDao;
import com.fzu.shhtest.dao.DdRoleDao;
import com.fzu.shhtest.dao.PersonnelDao;
import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.DdRole;
import com.fzu.shhtest.domain.Personnel;

public class DdRoleServiceImpl implements DdRoleService {
	private DdRoleDao ddRoleDao;
	public void setDdRoleDao(DdRoleDao ddRoleDao) {
		this.ddRoleDao = ddRoleDao;
	}
	@Override
	public int createDdRole(DdRole ddRole) {
		// TODO Auto-generated method stub
		ddRoleDao.createDdRole(ddRole);
		return 0;
	}

	@Override
	public boolean deleteDdRoleByName(String dname) {
		// TODO Auto-generated method stub
		return ddRoleDao.deleteDdRoleByName(dname);
	}

	@Override
	public DdRole getDdRoleStateByName(String dname) {
		// TODO Auto-generated method stub
		return ddRoleDao.getDdRoleStateByName(dname);
	}

	@Override
	public boolean updateDdRoleStateByName(DdRole ddRole,String oldDname) {
		// TODO Auto-generated method stub
		return ddRoleDao.updateDdRoleStateByName(ddRole,oldDname);
	}
	
	@Override
	public List getAllDdRole() {
		// TODO Auto-generated method stub
		return ddRoleDao.getAllDdRole();
	}
}
