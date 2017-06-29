package com.fzu.shhtest.dao;

import java.util.List;

import com.fzu.shhtest.domain.DdClassDate;

public interface DdClassDateDao {
	//Ôö
	int createDdClassDate(DdClassDate ddClassDate);
	
	//É¾
	boolean deleteDdClassDateByName(String dname);
	
	//¸Ä
	boolean updateDdClassDateStateByName(DdClassDate ddClassDate,String oldDname);

	//²é
	DdClassDate getDdClassDateStateByName(String dname);
	DdClassDate getDdClassDateStateByValue(int value);
	List getAllDdClassDate();	
}
