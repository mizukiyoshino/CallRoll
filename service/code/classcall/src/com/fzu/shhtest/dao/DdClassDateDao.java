package com.fzu.shhtest.dao;

import java.util.List;

import com.fzu.shhtest.domain.DdClassDate;

public interface DdClassDateDao {
	int createDdClassDate(DdClassDate ddClassDate);
	boolean deleteDdClassDateByName(String dname);
	DdClassDate getDdClassDateStateByName(String dname);
	DdClassDate getDdClassDateStateByValue(int value);
	boolean updateDdClassDateStateByName(DdClassDate ddClassDate);
	List getAllDdClassDate();	
}
