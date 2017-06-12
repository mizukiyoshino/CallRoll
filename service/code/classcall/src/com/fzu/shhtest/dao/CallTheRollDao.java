package com.fzu.shhtest.dao;

import java.util.Date;
import java.util.List;

import com.fzu.shhtest.domain.CallTheRoll;

public interface CallTheRollDao {
	int createCallTheRoll(CallTheRoll callTheRoll);

	boolean deleteCallTheRollByID(String ID);

	boolean updateCallTheRoll(CallTheRoll callTheRoll);

	List getAllCallTheRoll();

	List getCallTheRollByDate(Date date);
	
	List getCallTheRollBetweenDate(Date date1,Date date2);
	
	List getCallTheRollByID(String ID);
	
	List getCallTheRollByCoursename(String cname);
}