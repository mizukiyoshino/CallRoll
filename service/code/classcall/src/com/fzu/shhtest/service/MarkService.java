package com.fzu.shhtest.service;

import java.util.List;

import com.fzu.shhtest.domain.Mark;

public interface MarkService {
	int createMark(Mark mark);

	boolean deleteMarkByName(String cname);

	boolean updateMark(Mark mark);

	List getAllMark();

	List getMarkByName(String cname);
	
	List getMarkByID(String ID);
	
	Mark getMarkByNameAndID(String cname,String ID);
}
