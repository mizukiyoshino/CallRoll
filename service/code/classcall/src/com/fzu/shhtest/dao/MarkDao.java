package com.fzu.shhtest.dao;

import java.util.List;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.Mark;
import com.fzu.shhtest.domain.Personnel;

public interface MarkDao {
	int createMark(Mark mark);

	boolean deleteMarkByName(String cname);

	boolean updateMark(Mark mark);

	List getAllMark();

	List getMarkByName(String cname);
	
	List getMarkByID(String ID);
	
	Mark getMarkByNameAndID(String cname,String ID);
}
