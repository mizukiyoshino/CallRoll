package com.fzu.shhtest.dao;

import java.util.List;
import com.fzu.shhtest.domain.DdMajor;

public interface DdMajorDao {
	//Ôö
	int createDdMajor(DdMajor ddMajor);
	
	//É¾
	boolean deleteDdMajorByName(String dname);
	
	//¸Ä
	boolean updateDdMajorStateByName(DdMajor ddMajor,String oldDname);	
	
	//²é
	DdMajor getDdMajorStateByName(String dname);
	List getAllDdMajor();	
}
