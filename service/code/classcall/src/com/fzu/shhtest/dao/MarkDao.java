package com.fzu.shhtest.dao;

import java.util.List;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.Mark;
import com.fzu.shhtest.domain.Personnel;

public interface MarkDao {
	//Ôö
	int createMark(Mark mark);
	
	//É¾
	boolean deleteMarkByName(String cname);
	
	//¸Ä
	boolean updateMark(Mark mark);
	
	//²é
	List getAllMark();
	List getMarkByName(String cname);
	List getMarkByID(String ID);
	Mark getMarkByNameAndID(String cname,String ID);
}
