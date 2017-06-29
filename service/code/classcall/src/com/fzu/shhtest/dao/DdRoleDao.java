package com.fzu.shhtest.dao;

import java.util.List;

import com.fzu.shhtest.domain.DdRole;

public interface DdRoleDao {
	int createDdRole(DdRole ddRole);
	boolean deleteDdRoleByName(String dname);
	DdRole getDdRoleStateByName(String dname);
	boolean updateDdRoleStateByName(DdRole ddRole);
	List getAllDdRole();	
}
