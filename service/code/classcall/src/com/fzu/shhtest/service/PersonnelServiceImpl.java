package com.fzu.shhtest.service;

import java.util.List;

import com.fzu.shhtest.dao.PersonnelDao;
import com.fzu.shhtest.domain.Personnel;

public class PersonnelServiceImpl implements PersonnelService {
	private PersonnelDao personnelDao;

	public void setPersonnelDao(PersonnelDao personnelDao) {
		this.personnelDao = personnelDao;
	}

	@Override
	public int createPersonnel(Personnel personnel) {
		// TODO Auto-generated method stub
		return personnelDao.createPersonnel(personnel);
	}

	@Override
	public boolean deletePersonnelByName(String sname) {
		// TODO Auto-generated method stub
		return personnelDao.deletePersonnelByName(sname);
	}

	public boolean deletePersonnelByID(String id) {
		// TODO Auto-generated method stub
		return personnelDao.deletePersonnelByID(id);
	}

	@Override
	public boolean updatePersonnel(Personnel personnel) {
		// TODO Auto-generated method stub
		return personnelDao.updatePersonnel(personnel);
	}

	@Override
	public List getAllPersonnel() {
		// TODO Auto-generated method stub
		return personnelDao.getAllPersonnel();
	}

	@Override
	public List getAllPersonnelHql() {
		// TODO Auto-generated method stub
		return personnelDao.getAllPersonnelHql();
	}

	@Override
	public Personnel getPersonnelByName(String pname) {
		// TODO Auto-generated method stub
		return personnelDao.getPersonnelByName(pname);
	}
	
	@Override
	public List getPersonnelByNameHql(String pname) {
		// TODO Auto-generated method stub
		return personnelDao.getPersonnelByNameHql(pname);
	}

	@Override
	public Personnel getPersonnelByID(String ID) {
		// TODO Auto-generated method stub
		return personnelDao.getPersonnelByID(ID);
	}
	
	@Override
	public List getPersonnelByIDHql(String ID) {
		// TODO Auto-generated method stub
		return personnelDao.getPersonnelByIDHql(ID);
	}

}
