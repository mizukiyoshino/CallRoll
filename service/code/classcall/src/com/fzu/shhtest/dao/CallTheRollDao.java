package com.fzu.shhtest.dao;

import java.util.Date;
import java.util.List;

import com.fzu.shhtest.domain.CallTheRoll;

public interface CallTheRollDao {
	//Ôö
	int createCallTheRoll(CallTheRoll callTheRoll);

	//É¾
	boolean deleteCallTheRollByID(String ID);

	//¸Ä
	boolean updateCallTheRoll(CallTheRoll callTheRoll);

	//²é
	List getAllCallTheRoll();
	List getCallTheRollByDate(Date date);
	List getCallTheRollBetweenDate(Date date1,Date date2);
	List getCallTheRollByID(String ID);	
	List getCallTheRollByCoursename(String cname);
}