package com.fzu.shhtest.dao;

import java.util.List;

import com.fzu.shhtest.domain.Personnel;

public interface PersonnelDao {
	//Ôö
	int createPersonnel(Personnel personnel);
	
	//É¾
	boolean deletePersonnelByName(String sname);
	boolean deletePersonnelByID(String id);

	//¸Ä
	boolean updatePersonnel(Personnel personnel);

	//²é
	List getAllPersonnel();
	List getAllPersonnelHql();
	Personnel getPersonnelByName(String pname);
	List getPersonnelByNameHql(String pname);
	Personnel getPersonnelByID(String ID);
	List getPersonnelByIDHql(String ID);
	
}
