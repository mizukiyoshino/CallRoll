package com.fzu.shhtest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.nt.NTEventLogAppender;
import org.apache.struts2.ServletActionContext;

import com.fzu.shhtest.domain.CallTheRoll;
import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.Mark;
import com.fzu.shhtest.domain.Personnel;
import com.fzu.shhtest.service.CallTheRollService;
import com.fzu.shhtest.service.MarkService;
import com.fzu.shhtest.utils.ResultUtils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CallTheRollAction extends ActionSupport {
	private CallTheRollService callTheRollService;
	private MarkService markService;

	public void setCallTheRollService(CallTheRollService callTheRollService) {
		this.callTheRollService = callTheRollService;
	}

	public void setMarkService(MarkService markService) {
		this.markService = markService;
	}

	public String execute() {
		return SUCCESS;
	}

	public String createCallTheRoll() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		System.out.println("in createCallTheRoll");
		String contentType = request.getHeader("Content-Type");
		String courseName = ResultUtils.getPostParameter(param, "coursename",
				contentType);
		String callstate = ResultUtils.getPostParameter(param, "callstate",
				contentType);
		String calldate = ResultUtils.getPostParameter(param, "calldate",
				contentType);
		String ID = ResultUtils.getPostParameter(param, "id", contentType);
		String callposition = ResultUtils.getPostParameter(param,
				"callposition", contentType);
		if (calldate.equals("1")) {
			Date date = new Date();
			System.out.println(date.toString());
			calldate = "" + (date.getYear() + 1900) + "-"
					+ (date.getMonth() + 1) + "-" + date.getDate();
			System.out.println(date.getMonth());
		}
		CallTheRoll callTheRoll = new CallTheRoll();
		callTheRoll.setCourseName(courseName);
		callTheRoll.setCallstate(Integer.parseInt(callstate));
		callTheRoll.setCalldate(ResultUtils.stringToDate(calldate));
		callTheRoll.setID(ID);
		callTheRoll.setCallposition(callposition);

		callTheRollService.createCallTheRoll(callTheRoll);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String deleteCallTheRollByID() throws IOException {
		// http://localhost:8080/shhTest/calltherollaction/deleteCallTheRollByID
		// autoid=1&callstate=3&calldate=2017-06-12&callposition=5*2&id=160327000
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String ID = ResultUtils.getPostParameter(param, "id", contentType);
		callTheRollService.deleteCallTheRollByID(ID);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String updateCallTheRoll() throws IOException {
		// http://localhost:8080/shhTest/calltherollaction/updateCallTheRoll
		// autoid=1&callstate=2&calldate=2017-06-12&callposition=5*2
		System.out.println("in updateCallTheRoll.........");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		System.out.println("in updateCallTheRoll");
		String contentType = request.getHeader("Content-Type");
		String autoid = ResultUtils.getPostParameter(param, "autoid",contentType);
		String callstate = ResultUtils.getPostParameter(param, "callstate",contentType);
		String cname = ResultUtils.getPostParameter(param, "coursename",contentType);
		
		System.out.println("cname:  "+cname);
		
		String calldate = ResultUtils.getPostParameter(param, "calldate",contentType);
		String callposition = ResultUtils.getPostParameter(param,"callposition",contentType);
		String id = ResultUtils.getPostParameter(param, "id", contentType);
		Map<String, Object> map = new HashMap<String, Object>();
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		if (calldate.equals("1")) {
			Date date = new Date();
			calldate = "" + (date.getYear() + 1900) + "-"
					+ (date.getMonth() + 1) + "-" + date.getDate();
		}
		if (autoid.equals("0")) {//表示学生端签到，否则表示前台管理更新
			long tautoid = callTheRollService.getAutoidOfCallTheRollByIDAndCoursenameAndDate(id, cname, ResultUtils.stringToDate(calldate));
			if(tautoid==0){
				map.put("state", "非签到时间");
				ResultUtils.toJson(response, map);
				System.out.println("iffffffff  ");
				return null;
			}
			else{
				System.out.println("elseeeeeeeeeeeee  "+tautoid);
				autoid = ""+tautoid;
			}
		}
		CallTheRoll callTheRoll = new CallTheRoll();
		callTheRoll.setAutoid(Long.parseLong(autoid));
		callTheRoll.setCallstate(Integer.parseInt(callstate));
		callTheRoll.setCalldate(ResultUtils.stringToDate(calldate));
		callTheRoll.setCallposition(callposition);
		callTheRoll.setCourseName(cname);
		callTheRoll.setID(id);
		callTheRollService.updateCallTheRoll(callTheRoll);
		
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getAllCallTheRoll() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<CallTheRoll> list = (List<CallTheRoll>) callTheRollService
				.getAllCallTheRoll();
		map.put("calltherolls", list);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCallTheRollByDate() throws IOException {
		// http://localhost:8080/shhTest/calltherollaction/getCallTheRollByDate
		// id=160327000&coursename=网络工程&calldate=2017-06-14
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String calldate = ResultUtils.getPostParameter(param, "calldate",
				contentType);
		Date date = ResultUtils.stringToDate(calldate);
		List<CallTheRoll> callTheRolls = callTheRollService
				.getCallTheRollByDate(date);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("callTheRolls", callTheRolls);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCallTheRollBetweenDate() throws IOException {
		// id=160327000&coursename=网络工程&bcalldate=2017-06-14&acalldate=2017-06-14
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String bcalldate = ResultUtils.getPostParameter(param, "bcalldate",
				contentType);// before
		String acalldate = ResultUtils.getPostParameter(param, "acalldate",
				contentType);// after
		Date bdate = ResultUtils.stringToDate(bcalldate);
		Date adate = ResultUtils.stringToDate(acalldate);
		List<CallTheRoll> callTheRolls = callTheRollService
				.getCallTheRollBetweenDate(bdate, adate);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("callTheRolls", callTheRolls);
		ResultUtils.toJson(response, map);
		return null;
	}
	

	public String getCallTheRollByID() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String ID = ResultUtils.getPostParameter(param, "id", contentType);
		List<CallTheRoll> callTheRolls = callTheRollService
				.getCallTheRollByID(ID);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("callTheRolls", callTheRolls);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCallTheRollByCoursename() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String cname = ResultUtils.getPostParameter(param, "coursename",
				contentType);
		List<CallTheRoll> callTheRolls = callTheRollService
				.getCallTheRollByCoursename(cname);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("callTheRolls", callTheRolls);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCallTheRollByIDAndCoursename() throws IOException {
		System.out.println("in id and cname");
		HttpServletRequest request = ServletActionContext.getRequest();
		// quest.setHeader("Access-Control-Allow-Headers","*"); ;
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}

		String contentType = request.getHeader("Content-Type");
		String ID = ResultUtils.getPostParameter(param, "id", contentType);
		String cname = ResultUtils.getPostParameter(param, "coursename",
				contentType);
		System.out.println("cname:  " + cname);
		List<CallTheRoll> callTheRolls = callTheRollService
				.getCallTheRollByIDAndCoursename(ID, cname);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("callTheRolls", callTheRolls);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCallTheRollByIDAndCoursenameHql() throws IOException {
		// System.out.println("in id and cname");
		HttpServletRequest request = ServletActionContext.getRequest();
		// quest.setHeader("Access-Control-Allow-Headers","*"); ;
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String ID = ResultUtils.getPostParameter(param, "id", contentType);
		String cname = ResultUtils.getPostParameter(param, "coursename",
				contentType);
		// System.out.println("cname:  "+cname);

		List<CallTheRoll> callTheRolls = callTheRollService
				.getCallTheRollByIDAndCoursenameHql(ID, cname);
		String[] parameters = { "autoid", "courseName", "ID", "callstate",
				"calldate", "callposition" };
		List<Map<String, Object>> maplist = ResultUtils.setResults(
				callTheRolls, parameters);// new ArrayList<Map<String,
											// Object>>();

		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("callTheRolls", maplist);
		ResultUtils.toJson(response, map);
		return null;
	}

	// ..................HQL..........................................

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getAllCallTheRollHql() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<CallTheRoll> list = (List<CallTheRoll>) callTheRollService
				.getAllCallTheRollHql();
		String[] parameters = { "autoid", "courseName", "ID", "callstate",
				"calldate", "callposition" };
		List<Map<String, Object>> maplist = ResultUtils.setResults(list,
				parameters);// new ArrayList<Map<String, Object>>();

		map.put("calltherolls", maplist);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCallTheRollByDateHql() throws IOException {
		// http://localhost:8080/shhTest/calltherollaction/getCallTheRollByDate
		// id=160327000&coursename=网络工程&calldate=2017-06-14
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String calldate = ResultUtils.getPostParameter(param, "calldate",
				contentType);
		Date date = ResultUtils.stringToDate(calldate);
		List<CallTheRoll> callTheRolls = callTheRollService
				.getCallTheRollByDateHql(calldate);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		String[] parameters = { "autoid", "courseName", "ID", "callstate",
				"calldate", "callposition" };
		List<Map<String, Object>> maplist = ResultUtils.setResults(
				callTheRolls, parameters);// new ArrayList<Map<String,
											// Object>>();

		map.put("callTheRolls", maplist);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCallTheRollBetweenDateHql() throws IOException {
		// id=160327000&coursename=网络工程&bcalldate=2017-06-14&acalldate=2017-06-14
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String bcalldate = ResultUtils.getPostParameter(param, "bcalldate",
				contentType);// before
		String acalldate = ResultUtils.getPostParameter(param, "acalldate",
				contentType);// after
		//Date bdate = ResultUtils.stringToDate(bcalldate);
		//Date adate = ResultUtils.stringToDate(acalldate);
		List<CallTheRoll> callTheRolls = callTheRollService
				.getCallTheRollBetweenDateHql(bcalldate, acalldate);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		String[] parameters = { "autoid", "courseName", "ID", "callstate",
				"calldate", "callposition", "pname" };
		List<Map<String, Object>> maplist = ResultUtils.setResults(
				callTheRolls, parameters);// new ArrayList<Map<String,
											// Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("callTheRolls", maplist);
		ResultUtils.toJson(response, map);
		return null;
	}
	public String getCallTheRollBetweenDateAndCoursename() throws IOException {
		// id=160327000&coursename=网络工程&bcalldate=2017-06-14&acalldate=2017-06-14
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String bcalldate = ResultUtils.getPostParameter(param, "bcalldate",
				contentType);// before
		String acalldate = ResultUtils.getPostParameter(param, "acalldate",
				contentType);// after
		String cname = ResultUtils.getPostParameter(param, "coursename",
				contentType);// after
		Date bdate = ResultUtils.stringToDate(bcalldate);
		Date adate = ResultUtils.stringToDate(acalldate);
		List<CallTheRoll> callTheRolls = callTheRollService.getCallTheRollBetweenDateAndCoursename(bcalldate, acalldate,cname);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		String[] parameters = { "autoid", "courseName", "ID", "callstate",
				"calldate", "callposition", "pname" };
		List<Map<String, Object>> maplist = ResultUtils.setResults(
				callTheRolls, parameters);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("callTheRolls", maplist);
		ResultUtils.toJson(response, map);
		return null;
	}
	
	

	public String getCallTheRollByIDHql() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String ID = ResultUtils.getPostParameter(param, "id", contentType);
		List<CallTheRoll> callTheRolls = callTheRollService
				.getCallTheRollByIDHql(ID);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		String[] parameters = { "autoid", "courseName", "ID", "callstate",
				"calldate", "callposition" };
		List<Map<String, Object>> maplist = ResultUtils.setResults(
				callTheRolls, parameters);// new ArrayList<Map<String,
											// Object>>();

		map.put("callTheRolls", maplist);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCallTheRollByCoursenameHql() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String cname = ResultUtils.getPostParameter(param, "coursename",
				contentType);
		List<CallTheRoll> callTheRolls = callTheRollService
				.getCallTheRollByCoursenameHql(cname);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		String[] parameters = { "autoid", "courseName", "ID", "callstate",
				"calldate", "callposition" };
		List<Map<String, Object>> maplist = ResultUtils.setResults(
				callTheRolls, parameters);// new ArrayList<Map<String,
											// Object>>();

		map.put("callTheRolls", maplist);
		ResultUtils.toJson(response, map);
		return null;
	}

	//根据课程名，学号统计某状态的次数
	public String countCallTheRoll() throws IOException {
		// http://localhost:8080/shhTest/calltherollaction/countCallTheRoll?id=160327000&callstate=1&coursename=网络工程
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String callstate = ResultUtils.getPostParameter(param, "callstate",
				contentType);
		String coursename = ResultUtils.getPostParameter(param, "coursename",
				contentType);
		String ID = ResultUtils.getPostParameter(param, "id", contentType);

		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		int countnum = callTheRollService.countCallTheRoll(
				Integer.parseInt(callstate), coursename, ID);
		map.put("countnum", countnum);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String countAllCallTheRoll() throws IOException {
		// http://localhost:8080/shhTest/calltherollaction/countCallTheRoll?id=160327000&callstate=1&coursename=网络工程
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String coursename = ResultUtils.getPostParameter(param, "coursename",
				contentType);

		List<Mark> marks = markService.getMarkByName(coursename);
		if(marks==null)
			System.out.println("null of marks : "+marks.size());
		else
			System.out.println("yes of marks : "+marks.size());
		List<Map<String, Map<String, Object>>> counts = new ArrayList<Map<String, Map<String, Object>>>();
		System.out.println("size of marks : "+marks.size());
		for (Mark mark : marks) {
			Map<String, Map<String, Object>> tttmap= callTheRollService.countAllCallTheRoll(coursename, mark
					.getCnameAndID().getID());
			
			counts.add(tttmap);
		}
		System.out.println(counts);

		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		// int countnum = callTheRollService.countAllCallTheRoll(coursename);
		map.put("counts", counts);
		ResultUtils.toJson(response, map);
		return null;
	}

	// 根据课程名和日期将当日签到全部置为旷课
	public String callOverByCoursenameAndDate() throws IOException {
		// http://localhost:8080/shhTest/calltherollaction/countCallTheRoll?id=160327000&callstate=1&coursename=网络工程
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String contentType = request.getHeader("Content-Type");
		String coursename = ResultUtils.getPostParameter(param, "coursename",
				contentType);

		List<Mark> marks = markService.getMarkByName(coursename);
		//List<Map<String, Map<String, Object>>> counts = new ArrayList<Map<String, Map<String, Object>>>();
		CallTheRoll callTheRoll = null;
		Date date = new Date();
		System.out.println(date.toString());
		String calldate = "" + (date.getYear() + 1900) + "-"+ (date.getMonth() + 1) + "-" + date.getDate();
		Date cdate = ResultUtils.stringToDate(calldate);
		for (Mark mark : marks) {
			callTheRoll = new CallTheRoll(coursename, mark.getCnameAndID()
					.getID(), 3, cdate, "0*0");
			callTheRollService.createCallTheRoll(callTheRoll);
			// counts.add(callTheRollService.createCallTheRoll(callTheRoll);//(coursename,mark.getCnameAndID().getID()));
		}
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		// int countnum = callTheRollService.countAllCallTheRoll(coursename);
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}
	
}
