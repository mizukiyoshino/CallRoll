package com.fzu.shhtest.dao;

import com.fzu.shhtest.domain.SchoolInfo;
public interface SchoolInfoDao {
	//Ôö
	int createSchoolInfo(SchoolInfo schoolInfo);
	
	//É¾
	boolean deleteSchoolInfo();
	
	//¸Ä
	boolean updateSchoolInfo(SchoolInfo schoolInfo);
	
	//²é
	SchoolInfo getSchoolInfo();
}
