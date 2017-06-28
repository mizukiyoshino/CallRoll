package com.fzu.shhtest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fzu.shhtest.domain.CallTheRoll;
import com.fzu.shhtest.domain.DdState;
import com.fzu.shhtest.domain.Personnel;
import com.fzu.shhtest.utils.ResultUtils;

public class CallTheRollDaoImpl implements CallTheRollDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private Session getSession() {
		if (sessionFactory == null)
			return null;
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int createCallTheRoll(CallTheRoll callTheRoll) {
		// TODO Auto-generated method stub
		Session session = getSession();
		session.save(callTheRoll);
		return 0;
	}

	@Override
	public boolean deleteCallTheRollByID(String ID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<CallTheRoll> callTheRolls = getCallTheRollByID(ID);
		for(CallTheRoll callTheRoll:callTheRolls)
		{
			session.delete(callTheRoll);
		}
		return false;
	}

	@Override
	public boolean updateCallTheRoll(CallTheRoll callTheRoll) {
		// TODO Auto-generated method stub
		Session session = getSession();
		CallTheRoll newcallTheRoll = getCallTheRollByAutoId(callTheRoll.getAutoid());
		newcallTheRoll.setCalldate(callTheRoll.getCalldate());
		newcallTheRoll.setCallposition(callTheRoll.getCallposition());
		newcallTheRoll.setCallstate(callTheRoll.getCallstate());
		session.update(newcallTheRoll);
		return false;
	}

	@Override
	public List getAllCallTheRoll() {
		Session session = getSession();
		List list = session.createQuery("from CallTheRoll").list();
		return list;
	}

	@Override
	public List getCallTheRollByDate(Date date) {
		Session session = getSession();
		Query query = session.createQuery("from CallTheRoll where calldate=?");
		query.setDate(0, date);
		List<CallTheRoll> list = (List<CallTheRoll>) query.list();
		return list;
	}

	public CallTheRoll getCallTheRollByAutoId(long autoid) {
		Session session = getSession();
		Query query = session.createQuery("from CallTheRoll where autoid=?");
		query.setLong(0, autoid);
		List<CallTheRoll> callTheRoll = (ArrayList<CallTheRoll>) query.list();
		if(callTheRoll!=null)
		{
			return callTheRoll.get(0);
		}
		return null;
	}

	@Override
	public List getCallTheRollBetweenDate(Date date1, Date date2) {
		Session session = getSession();
		Query query = session.createQuery("from CallTheRoll where calldate>=? and calldate<=?");
		query.setDate(0, date1);
		query.setDate(1, date2);
		List<CallTheRoll> list = (List<CallTheRoll>) query.list();
		return list;
	}

	@Override
	public List getCallTheRollByID(String ID) {
		Session session = getSession();
		Query query = session.createQuery("from CallTheRoll where ID=?");
		query.setString(0, ID);
		List<CallTheRoll> list = (List<CallTheRoll>) query.list();
		return list;
	}

	@Override
	public List getCallTheRollByCoursename(String cname) {
		Session session = getSession();
		Query query = session.createQuery("from CallTheRoll where courseName=?");
		query.setString(0, cname);
		List<CallTheRoll> list = (List<CallTheRoll>) query.list();
		return list;
	}

	@Override
	public List getCallTheRollByIDAndCoursename(String id,String cname) {
		Session session = getSession();
		Query query = session.createQuery("from CallTheRoll where ID=? AND courseName=?");
		query.setString(0, id);
		query.setString(1, cname);
		List<CallTheRoll> list = (List<CallTheRoll>) query.list();
		return list;
	}
	

	@Override
	public List getCallTheRollByIDAndCoursenameHql(String id,String cname) {
		Session session = getSession();
		String hqlString = "SELECT autoid,courseName,ID,dname,calldate,callposition FROM calltheroll AS a,ddstate AS d WHERE a.callstate=d.callstate AND ID="+id+" AND courseName=\'"+cname+"\';";
		Query query = session.createSQLQuery(hqlString);
		
		//Session session = getSession();
		//Query query = session.createQuery("from CallTheRoll where ID=? AND courseName=?");
		//query.setString(0, id);
		//query.setString(1, cname);
		List list = query.list();
		return list;
	}
	
	
	//...........................HQL................................
	@Override
	public List getAllCallTheRollHql() {
		Session session = getSession();
		String hqlString = "SELECT autoid,courseName,ID,d.dname AS callstate,calldate,callposition FROM calltheroll AS c,ddstate AS d WHERE c.callstate=d.callstate;";
		Query query = session.createSQLQuery(hqlString);
		List list = query.list();
		return list;
	}

	@Override
	public List getCallTheRollByDateHql(String date) {
		Session session = getSession();
		String hqlString = "SELECT autoid,courseName,ID,d.dname AS callstate,calldate,callposition FROM calltheroll AS c,ddstate AS d WHERE c.callstate=d.callstate AND c.calldate=\'"+date+"\';";
		Query query = session.createSQLQuery(hqlString);
		List list = query.list();
		return list;
	}
	
	@Override
	public List getCallTheRollBetweenDateHql(String date1, String date2) {
		Session session = getSession();
		String hqlString = "SELECT autoid,courseName,ID,d.dname AS callstate,calldate,callposition FROM calltheroll AS c,ddstate AS d WHERE c.callstate=d.callstate AND c.calldate>=\'"+date1+"\' AND c.calldate<=\'"+date2+"\';";
		Query query = session.createSQLQuery(hqlString);
		List list = query.list();
		return list;
	}

	@Override
	public List getCallTheRollByIDHql(String ID) {
		Session session = getSession();
		String hqlString = "SELECT autoid,courseName,ID,d.dname AS callstate,calldate,callposition FROM calltheroll AS c,ddstate AS d WHERE c.callstate=d.callstate AND c.ID="+ID+";";
		Query query = session.createSQLQuery(hqlString);
		List list = query.list();
		return list;
	}

	@Override
	public List getCallTheRollByCoursenameHql(String cname) {
		Session session = getSession();
		String hqlString = "SELECT autoid,courseName,ID,d.dname AS callstate,calldate,callposition FROM calltheroll AS c,ddstate AS d WHERE c.callstate=d.callstate AND c.courseName=\'"+cname+"\';";
		Query query = session.createSQLQuery(hqlString);
		List list = query.list();
		return list;
	}
	@Override
	public int countCallTheRoll(int callstate,String coursename,String ID)
	{
		Session session = getSession();
		String hqlString = "SELECT COUNT(*) FROM calltheroll WHERE ID="+ID+" AND callstate="+callstate+" AND courseName=\'"+coursename+"\';";
		Query query = session.createSQLQuery(hqlString);
		List list = query.list();
		//System.out.println("countCallTheRoll:  "+coursename+"   "+Integer.parseInt(query.getQueryString()));
		return Integer.parseInt(query.list().get(0).toString());
	}
	
	@Override
	public Map<String, Map<String, Object>> countAllCallTheRoll(String coursename,String ID){
		Map<String, Map<String, Object>> maps = new LinkedHashMap<String, Map<String,Object>>();
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		Session session = getSession();
		List list = session.createQuery("from DdState").list();
		List<DdState> ddStates = (ArrayList<DdState>)list;
		int count = 0;
		for(DdState ddState:ddStates)
		{
			count = countCallTheRoll(ddState.getCallstate(),coursename,ID);
			map.put(ddState.getDname(), count);
		}
		maps.put(ID, map);
		return maps;
	}
	
}
