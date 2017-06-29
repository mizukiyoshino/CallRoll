package com.fzu.shhtest.service;

import java.util.List;

import com.fzu.shhtest.dao.DdClassDateDao;
import com.fzu.shhtest.domain.DdClassDate;

public class DdClassDateServiceImpl implements DdClassDateService {
	private DdClassDateDao ddClassDateDao;
	public void setDdClassDateDao(DdClassDateDao ddClassDateDao) {
		this.ddClassDateDao = ddClassDateDao;
	}
	@Override
	public int createDdClassDate(DdClassDate ddClassDate) {
		// TODO Auto-generated method stub
		return ddClassDateDao.createDdClassDate(ddClassDate);
	}

	@Override
	public boolean deleteDdClassDateByName(String dname) {
		// TODO Auto-generated method stub
		return ddClassDateDao.deleteDdClassDateByName(dname);
	}

	@Override
	public DdClassDate getDdClassDateStateByName(String dname) {
		// TODO Auto-generated method stub
		return ddClassDateDao.getDdClassDateStateByName(dname);
	}
	@Override
	public DdClassDate getDdClassDateStateByValue(int value) {
		// TODO Auto-generated method stub
		return ddClassDateDao.getDdClassDateStateByValue(value);
	}

	@Override
	public boolean updateDdClassDateStateByName(DdClassDate ddClassDate) {
		// TODO Auto-generated method stub
		return ddClassDateDao.updateDdClassDateStateByName(ddClassDate);
	}

	@Override
	public List getAllDdClassDate() {
		// TODO Auto-generated method stub
		return ddClassDateDao.getAllDdClassDate();
	}
}
