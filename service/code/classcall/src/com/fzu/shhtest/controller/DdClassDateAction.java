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

import com.fzu.shhtest.domain.DdClassDate;
import com.fzu.shhtest.domain.DdRole;
import com.fzu.shhtest.service.DdClassDateService;
import com.fzu.shhtest.utils.ResultUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DdClassDateAction extends ActionSupport {
	private DdClassDateService ddClassDateService;

	public void setDdClassDateService(DdClassDateService ddClassDateService) {
		this.ddClassDateService = ddClassDateService;
	}

	public String execute() {
		return SUCCESS;
	}

	public String createDdClassDate() throws IOException {
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
		String classDate = ResultUtils.getPostParameter(param, "classDate");
		String state = new String("启用");
		DdClassDate ddClassDate = new DdClassDate();

		ddClassDate.setDname(dname);
		ddClassDate.setClassDate(Integer.parseInt(classDate));
		ddClassDate.setState(state);
		ddClassDateService.createDdClassDate(ddClassDate);

		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String deleteDdClassDateByName() throws IOException {
		//localhost:8080/shhTest/ddClassDateaction/deleteDdClassDateByName?dname={‘0‘:'发达'}
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = ResultUtils.getRequestParameter(request, "dname");

		System.out.println("ids   "+ids);
		Gson gson = new Gson();
		Map<String, String> rtn = gson.fromJson(ids,
				new TypeToken<Map<String, String>>() {
				}.getType());
		for (Entry<String, String> entry : rtn.entrySet()) {
			String id = entry.getValue();
			ddClassDateService.deleteDdClassDateByName(id);
		}
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getDdClassDateStateByName() throws IOException {
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
		DdClassDate ddClassDate = ddClassDateService.getDdClassDateStateByName(dname);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ddClassDate", ddClassDate);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String updateDdClassDateStateByName() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String oldname = ResultUtils.getPostParameter(param, "oldname");
		String dname = ResultUtils.getPostParameter(param, "dname");
		String classDate = ResultUtils.getPostParameter(param, "classDate");
		String state = new String("启用");
		DdClassDate ddClassDate = new DdClassDate();

		ddClassDate.setDname(dname);
		ddClassDate.setClassDate(Integer.parseInt(classDate));
		ddClassDate.setState(state);
		ddClassDateService.updateDdClassDateStateByName(ddClassDate, oldname);

		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getAllDdClassDate() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<DdClassDate> list = (List<DdClassDate>) ddClassDateService
				.getAllDdClassDate();
		map.put("ddClassDates", list);
		ResultUtils.toJson(response, map);
		return null;
	}
}