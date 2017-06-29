package com.fzu.shhtest.controller;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fzu.shhtest.domain.DdRole;
import com.fzu.shhtest.domain.DdState;
import com.fzu.shhtest.service.DdStateService;
import com.fzu.shhtest.utils.ResultUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DdStateAction extends ActionSupport {
	private DdStateService ddStateService;
	public void setDdStateService(DdStateService ddStateService) {
		this.ddStateService = ddStateService;
	}
	public String execute() {
		return SUCCESS;
	}
	public String createDdState() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String dname = ResultUtils.getPostParameter(param, "dname");
		String callstate = ResultUtils.getPostParameter(param, "callstate");
		String state = new String("ÆôÓÃ");
		DdState ddState = new DdState();

		ddState.setDname(dname);
		ddState.setCallstate(Integer.parseInt(callstate));
		ddState.setState(state);
		ddStateService.createDdState(ddState);
		
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String deleteDdStateByName() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();
		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String ids = ResultUtils.getRequestParameter(request, "dname");
		
		Gson gson = new Gson();
		Map<String, String> rtn = gson.fromJson(ids,
				new TypeToken<Map<String, String>>() {
				}.getType());
		for (Entry<String, String> entry : rtn.entrySet()) {
			String id = entry.getValue();
			System.out.println("id   "+id);
			ddStateService.deleteDdStateByName(id);
		}
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getDdStateStateByName() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();
		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String dname = ResultUtils.getRequestParameter(request, "dname");
		System.out.println("dname:  " + dname);
		DdState ddState = ddStateService.getDdStateStateByName(dname);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ddState", ddState);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String updateDdStateStateByName() throws IOException {
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
		String oldname = ResultUtils.getPostParameter(param, "oldname",contentType);
		String dname = ResultUtils.getPostParameter(param, "dname",contentType);
		String callstate = ResultUtils.getPostParameter(param, "callstate",contentType);
		String state = new String("ÆôÓÃ");
		DdState ddState = new DdState();
		ddState.setDname(dname);
		ddState.setCallstate(Integer.parseInt(callstate));
		ddState.setState(state);
		ddStateService.updateDdStateStateByName(ddState,oldname);

		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getAllDdState() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<DdState> list = (List<DdState>) ddStateService.getAllDdState();
		map.put("ddStates", list);
		ResultUtils.toJson(response, map);
		return null;
	}
}
