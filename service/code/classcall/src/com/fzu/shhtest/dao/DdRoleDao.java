package com.fzu.shhtest.dao;

import java.util.List;
import com.fzu.shhtest.domain.DdRole;

public interface DdRoleDao {
	//Ôö
	int createDdRole(DdRole ddRole);
	
	//É¾
	boolean deleteDdRoleByName(String dname);
	
	//¸Ä
	boolean updateDdRoleStateByName(DdRole ddRole,String oldDname);
	
	//²é
	DdRole getDdRoleStateByName(String dname);
	List getAllDdRole();	
}
