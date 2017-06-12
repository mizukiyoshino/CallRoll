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

import com.fzu.shhtest.domain.DdMajor;
import com.fzu.shhtest.domain.DdRole;
import com.fzu.shhtest.service.DdMajorService;
import com.fzu.shhtest.utils.ResultUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DdMajorAction extends ActionSupport {
	private DdMajorService ddMajorService;
	public void setDdMajorService(DdMajorService ddMajorService) {
		this.ddMajorService = ddMajorService;
	}

	public String execute() {
		return SUCCESS;
	}

	public String createDdMajor() throws IOException {
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
		String major = ResultUtils.getPostParameter(param, "major");
		String state = new String("ÆôÓÃ");
		DdMajor ddMajor = new DdMajor();

		ddMajor.setDname(dname);
		ddMajor.setMajor(Integer.parseInt(major));
		ddMajor.setState(state);
		ddMajorService.createDdMajor(ddMajor);
		
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String deleteDdMajorByName() throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = ResultUtils.getRequestParameter(request, "dname");
		Gson gson = new Gson();
		Map<String, String> rtn = gson.fromJson(ids,
				new TypeToken<Map<String, String>>() {
				}.getType());
		for (Entry<String, String> entry : rtn.entrySet()) {
			String id = entry.getValue();
			ddMajorService.deleteDdMajorByName(id);
		}
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		return null;
	}

	public String getDdMajorStateByName() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		//String dname = ResultUtils.getPostParameter(param, "dname");
		String dname = ResultUtils.getRequestParameter(request, "dname");
		
		System.out.println("dname   "+dname);
		DdMajor ddMajor = ddMajorService.getDdMajorStateByName(dname);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ddMajor", ddMajor);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String updateDdMajorStateByName() throws IOException {
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
		String major = ResultUtils.getPostParameter(param, "major");
		String state = new String("ÆôÓÃ");
		DdMajor ddMajor = new DdMajor();//ddMajorService.getDdMajorStateByName(oldname);
		ddMajor.setDname(dname);
		ddMajor.setMajor(Integer.parseInt(major));
		ddMajor.setState(state);
		ddMajorService.updateDdMajorStateByName(ddMajor,oldname);
		
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getAllDdMajor() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<DdMajor> list = (List<DdMajor>) ddMajorService.getAllDdMajor();
		map.put("ddMajors", list);
		System.out.println(map);
		ResultUtils.toJson(response, map);
		return null;
	}
}












