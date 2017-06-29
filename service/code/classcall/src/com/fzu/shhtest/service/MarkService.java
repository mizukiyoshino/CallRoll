package com.fzu.shhtest.service;

import java.util.List;

import com.fzu.shhtest.domain.Mark;

public interface MarkService {
	// Ôö
	int createMark(Mark mark);

	// É¾
	boolean deleteMarkByName(String cname);

	// ¸Ä
	boolean updateMark(Mark mark);

	// ²é
	List getAllMark();
	List getMarkByName(String cname);
	List getMarkByID(String ID);
	Mark getMarkByNameAndID(String cname, String ID);
}
