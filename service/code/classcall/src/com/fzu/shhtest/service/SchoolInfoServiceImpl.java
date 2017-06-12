package com.fzu.shhtest.service;

import com.fzu.shhtest.dao.SchoolInfoDao;
import com.fzu.shhtest.domain.SchoolInfo;

public class SchoolInfoServiceImpl implements SchoolInfoService {
	private SchoolInfoDao schoolInfoDao;	
	public void setSchoolInfoDao(SchoolInfoDao schoolInfoDao) {
		this.schoolInfoDao = schoolInfoDao;
	}

	@Override
	public int createSchoolInfo(SchoolInfo schoolInfo) {
		// TODO Auto-generated method stub
		return schoolInfoDao.createSchoolInfo(schoolInfo);
	}

	@Override
	public boolean deleteSchoolInfo() {
		// TODO Auto-generated method stub
		return schoolInfoDao.deleteSchoolInfo();
	}

	@Override
	public boolean updateSchoolInfo(SchoolInfo schoolInfo) {
		// TODO Auto-generated method stub
		return schoolInfoDao.updateSchoolInfo(schoolInfo);
	}

	@Override
	public SchoolInfo getSchoolInfo() {
		// TODO Auto-generated method stub
		return schoolInfoDao.getSchoolInfo();
	}
}
