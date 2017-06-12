package com.fzu.shhtest.service;

import com.fzu.shhtest.domain.SchoolInfo;

public interface SchoolInfoService {
	int createSchoolInfo(SchoolInfo schoolInfo);
	boolean deleteSchoolInfo();
	boolean updateSchoolInfo(SchoolInfo schoolInfo);
	SchoolInfo getSchoolInfo();
}
