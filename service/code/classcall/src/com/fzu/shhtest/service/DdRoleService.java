package com.fzu.shhtest.service;

import java.util.List;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.DdRole;
import com.fzu.shhtest.domain.Personnel;

public interface DdRoleService {
	int createDdRole(DdRole ddRole);
	boolean deleteDdRoleByName(String dname);
	DdRole getDdRoleStateByName(String dname);
	boolean updateDdRoleStateByName(DdRole ddRole,String oldDname);	
	List getAllDdRole();	
}
