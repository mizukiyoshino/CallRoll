package com.fzu.shhtest.dao;

import java.util.List;

import com.fzu.shhtest.domain.DdState;
public interface DdStateDao {
	int createDdState(DdState ddState);
	boolean deleteDdStateByName(String dname);
	DdState getDdStateStateByName(String dname);
	boolean updateDdStateStateByName(DdState ddState);
	List getAllDdState();
}
