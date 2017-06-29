package com.fzu.shhtest.dao;

import java.util.List;

import com.fzu.shhtest.domain.DdMajor;

public interface DdMajorDao {
	int createDdMajor(DdMajor ddMajor);
	boolean deleteDdMajorByName(String dname);
	DdMajor getDdMajorStateByName(String dname);
	boolean updateDdMajorStateByName(DdMajor ddMajor,String oldDname);	
	List getAllDdMajor();	
}
