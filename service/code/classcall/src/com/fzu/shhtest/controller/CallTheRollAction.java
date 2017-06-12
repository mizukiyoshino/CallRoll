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

	public String deleteCallTheRollByID() {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateCallTheRoll() {
		// TODO Auto-generated method stub
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

	public String getCallTheRollByDate() {
		return null;
	}

	public String getCallTheRollBetweenDate() {
		// TODO Auto-generated method stub
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
		String cname = ResultUtils.getPostParameter(param, "cname");
		List<CallTheRoll> callTheRolls = callTheRollService.getCallTheRollByCoursename(cname);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("callTheRolls", callTheRolls);
		ResultUtils.toJson(response, map);
		return null;
	}
}
