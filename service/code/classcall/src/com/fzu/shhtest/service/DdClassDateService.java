package com.fzu.shhtest.service;

import java.util.List;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.DdClassDate;
import com.fzu.shhtest.domain.DdMajor;
import com.fzu.shhtest.domain.DdRole;
import com.fzu.shhtest.domain.Personnel;

public interface DdClassDateService {
	int createDdClassDate(DdClassDate ddClassDate);
	boolean deleteDdClassDateByName(String dname);
	DdClassDate getDdClassDateStateByName(String dname);
	DdClassDate getDdClassDateStateByValue(int value);
	boolean updateDdClassDateStateByName(DdClassDate ddClassDate,String oldDname);
	List getAllDdClassDate();	
}
