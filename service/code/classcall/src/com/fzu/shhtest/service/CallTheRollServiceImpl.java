package com.fzu.shhtest.service;

import java.util.Date;
import java.util.List;

import com.fzu.shhtest.dao.CallTheRollDao;
import com.fzu.shhtest.dao.CourseDao;
import com.fzu.shhtest.domain.CallTheRoll;

public class CallTheRollServiceImpl implements CallTheRollService {
	private CallTheRollDao callTheRollDao;

	public void setCallTheRollDao(CallTheRollDao callTheRollDao) {
		this.callTheRollDao = callTheRollDao;
	}

	@Override
	public int createCallTheRoll(CallTheRoll callTheRoll) {
		// TODO Auto-generated method stub
		return callTheRollDao.createCallTheRoll(callTheRoll);
	}

	@Override
	public boolean deleteCallTheRollByID(String ID) {
		// TODO Auto-generated method stub
		return callTheRollDao.deleteCallTheRollByID(ID);
	}

	@Override
	public boolean updateCallTheRoll(CallTheRoll callTheRoll) {
		// TODO Auto-generated method stub
		return callTheRollDao.updateCallTheRoll(callTheRoll);
	}

	@Override
	public List getAllCallTheRoll() {
		// TODO Auto-generated method stub
		return callTheRollDao.getAllCallTheRoll();
	}

	@Override
	public List getCallTheRollByDate(Date date) {
		// TODO Auto-generated method stub
		return callTheRollDao.getCallTheRollByDate(date);
	}

	@Override
	public List getCallTheRollBetweenDate(Date date1, Date date2) {
		// TODO Auto-generated method stub
		return callTheRollDao.getCallTheRollBetweenDate(date1, date2);
	}

	@Override
	public List getCallTheRollByID(String ID) {
		// TODO Auto-generated method stub
		return callTheRollDao.getCallTheRollByID(ID);
	}

	@Override
	public List getCallTheRollByCoursename(String cname) {
		// TODO Auto-generated method stub
		return callTheRollDao.getCallTheRollByCoursename(cname);
	}
}
