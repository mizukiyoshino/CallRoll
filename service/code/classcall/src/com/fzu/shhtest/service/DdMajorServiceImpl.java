package com.fzu.shhtest.service;

import java.util.List;

import com.fzu.shhtest.dao.DdMajorDao;
import com.fzu.shhtest.domain.DdMajor;

public class DdMajorServiceImpl implements DdMajorService {
	private DdMajorDao ddMajorDao;
	public void setDdMajorDao(DdMajorDao ddMajorDao) {
		this.ddMajorDao = ddMajorDao;
	}
	@Override
	public int createDdMajor(DdMajor ddMajor) {
		// TODO Auto-generated method stub
		return ddMajorDao.createDdMajor(ddMajor);
	}
	@Override
	public boolean deleteDdMajorByName(String dname) {
		// TODO Auto-generated method stub
		return ddMajorDao.deleteDdMajorByName(dname);
	}

	@Override
	public DdMajor getDdMajorStateByName(String dname) {
		// TODO Auto-generated method stub
		return ddMajorDao.getDdMajorStateByName(dname);
	}

	@Override
	public boolean updateDdMajorStateByName(DdMajor ddMajor,String oldDname) {
		// TODO Auto-generated method stub
		return ddMajorDao.updateDdMajorStateByName(ddMajor,oldDname);
	}

	@Override
	public List getAllDdMajor() {
		// TODO Auto-generated method stub
		return ddMajorDao.getAllDdMajor();
	}
}
