package com.fzu.shhtest.dao;

import java.util.List;

import com.fzu.shhtest.domain.DdState;
public interface DdStateDao {
	//Ôö
	int createDdState(DdState ddState);
	
	//É¾
	boolean deleteDdStateByName(String dname);
	//¸Ä
	boolean updateDdStateStateByName(DdState ddState,String oldDname);

	//²é
	DdState getDdStateStateByName(String dname);
	List getAllDdState();
}
