package com.fzu.shhtest.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
	List getCallTheRollByIDAndCoursename(String id,String cname);
	long getAutoidOfCallTheRollByIDAndCoursenameAndDate(String id,String cname,Date calldate);	
	List getCallTheRollByIDAndCoursenameHql(String id,String cname);
	int countCallTheRoll(int callstate,String coursename,String ID);
	Map<String, Map<String, Object>> countAllCallTheRoll(String coursename,String ID);
	
	
	
	List getAllCallTheRollHql();
	List getCallTheRollByDateHql(String date);
	List getCallTheRollBetweenDateHql(String date1,String date2);
	List getCallTheRollBetweenDateAndCoursename(String date1,String date2,String coursename);
	
	
	List getCallTheRollByIDHql(String ID);	
	List getCallTheRollByCoursenameHql(String cname);
}