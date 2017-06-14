package com.fzu.shhtest.service;

import java.util.List;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.DdMajor;
import com.fzu.shhtest.domain.DdRole;
import com.fzu.shhtest.domain.DdState;
import com.fzu.shhtest.domain.Personnel;

public interface DdStateService {
	int createDdState(DdState ddState);
	boolean deleteDdStateByName(String dname);
	DdState getDdStateStateByName(String dname);
	boolean updateDdStateStateByName(DdState ddState,String oldname);
	List getAllDdState();
}
