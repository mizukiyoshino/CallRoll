package com.fzu.shhtest.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fzu.shhtest.domain.CallTheRoll;
import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.Personnel;
import com.fzu.shhtest.service.CallTheRollService;
import com.fzu.shhtest.utils.ResultUtils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CallTheRollAction extends ActionSupport {
	private CallTheRollService callTheRollService;

	public void setCallTheRollService(CallTheRollService callTheRollService) {
		this.callTheRollService = callTheRollService;
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
		String courseName = ResultUtils.getPostParameter(param, "coursename");
		String callstate = ResultUtils.getPostParameter(param, "callstate");
		String calldate = ResultUtils.getPostParameter(param, "calldate");
		String ID = ResultUtils.getPostParameter(param, "id");
		String callposition = ResultUtils.getPostParameter(param, "callposition");
		
		CallTheRoll callTheRoll = new CallTheRoll();
		callTheRoll.setCourseName(courseName);
		callTheRoll.setCallstate(Integer.parseInt(callstate));
		callTheRoll.setCalldate(new Date(calldate));
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
		//http://localhost:8080/shhTest/calltherollaction/deleteCallTheRollByID
		//autoid=1&callstate=3&calldate=2017-06-12&callposition=5*2&id=160327000
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}		
		String ID = ResultUtils.getPostParameter(param, "id");
		callTheRollService.deleteCallTheRollByID(ID);
		
		//Date date = ResultUtils.stringToDate(calldate);
		//List<CallTheRoll> callTheRolls = callTheRollService.getCallTheRollByDate(date);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String updateCallTheRoll() throws IOException {
		//http://localhost:8080/shhTest/calltherollaction/updateCallTheRoll
		//autoid=1&callstate=2&calldate=2017-06-12&callposition=5*2
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}		
		String autoid = ResultUtils.getPostParameter(param, "autoid");
		String callstate = ResultUtils.getPostParameter(param, "callstate");
		String calldate = ResultUtils.getPostParameter(param, "calldate");
		String callposition = ResultUtils.getPostParameter(param, "callposition");
		
		CallTheRoll callTheRoll = new CallTheRoll();
		callTheRoll.setAutoid(Long.parseLong(autoid));
		callTheRoll.setCallstate(Integer.parseInt(callstate));
		callTheRoll.setCalldate(ResultUtils.stringToDate(calldate));
		callTheRoll.setCallposition(callposition);
		
		callTheRollService.updateCallTheRoll(callTheRoll);
		
		//Date date = ResultUtils.stringToDate(calldate);
		//List<CallTheRoll> callTheRolls = callTheRollService.getCallTheRollByDate(date);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getAllCallTheRoll() throws IOException {
		HttpServletResponse response = ResultUtils.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<CallTheRoll> list = (List<CallTheRoll>) callTheRollService.getAllCallTheRoll();
		map.put("calltherolls", list);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCallTheRollByDate() throws IOException {
		//http://localhost:8080/shhTest/calltherollaction/getCallTheRollByDate
		//id=160327000&coursename=网络工程&calldate=2017-06-14
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String calldate = ResultUtils.getPostParameter(param, "calldate");
		Date date = ResultUtils.stringToDate(calldate);
		List<CallTheRoll> callTheRolls = callTheRollService.getCallTheRollByDate(date);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("callTheRolls", callTheRolls);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCallTheRollBetweenDate() throws IOException {
		//id=160327000&coursename=网络工程&bcalldate=2017-06-14&acalldate=2017-06-14
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String bcalldate = ResultUtils.getPostParameter(param, "bcalldate");//before
		String acalldate = ResultUtils.getPostParameter(param, "acalldate");//after
		Date bdate = ResultUtils.stringToDate(bcalldate);
		Date adate = ResultUtils.stringToDate(acalldate);
		List<CallTheRoll> callTheRolls = callTheRollService.getCallTheRollBetweenDate(bdate,adate);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("callTheRolls", callTheRolls);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCallTheRollByID() throws IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String ID = ResultUtils.getPostParameter(param, "id");
		List<CallTheRoll> callTheRolls = callTheRollService.getCallTheRollByID(ID);
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
		String cname = ResultUtils.getPostParameter(param, "coursename");
		List<CallTheRoll> callTheRolls = callTheRollService.getCallTheRollByCoursename(cname);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("callTheRolls", callTheRolls);
		ResultUtils.toJson(response, map);
		return null;
	}
}
