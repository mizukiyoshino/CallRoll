package com.fzu.shhtest.service;

import java.util.List;

import com.fzu.shhtest.dao.DdClassDateDao;
import com.fzu.shhtest.dao.DdStateDao;
import com.fzu.shhtest.domain.DdState;

public class DdStateServiceImpl implements DdStateService {
	private DdStateDao ddStateDao;
	public void setDdStateDao(DdStateDao ddStateDao) {
		this.ddStateDao = ddStateDao;
	}

	@Override
	public int createDdState(DdState ddState) {
		// TODO Auto-generated method stub
		return ddStateDao.createDdState(ddState);
	}

	@Override
	public boolean deleteDdStateByName(String dname) {
		// TODO Auto-generated method stub
		return ddStateDao.deleteDdStateByName(dname);
	}

	@Override
	public DdState getDdStateStateByName(String dname) {
		// TODO Auto-generated method stub
		return ddStateDao.getDdStateStateByName(dname);
	}

	@Override
	public boolean updateDdStateStateByName(DdState ddState) {
		// TODO Auto-generated method stub
		return ddStateDao.updateDdStateStateByName(ddState);
	}

	@Override
	public List getAllDdState() {
		// TODO Auto-generated method stub
		return ddStateDao.getAllDdState();
	}
}
