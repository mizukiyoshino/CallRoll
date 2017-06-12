package com.fzu.shhtest.service;

import java.util.List;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.DdMajor;
import com.fzu.shhtest.domain.DdRole;
import com.fzu.shhtest.domain.Personnel;

public interface DdMajorService {
	int createDdMajor(DdMajor ddMajor);
	boolean deleteDdMajorByName(String dname);
	DdMajor getDdMajorStateByName(String dname);
	boolean updateDdMajorStateByName(DdMajor ddMajor,String oldDname);
	List getAllDdMajor();	
}
