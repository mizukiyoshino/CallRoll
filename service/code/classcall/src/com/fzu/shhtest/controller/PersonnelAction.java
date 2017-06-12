package com.fzu.shhtest.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import com.fzu.shhtest.domain.Personnel;
import com.fzu.shhtest.service.PersonnelService;
import com.fzu.shhtest.utils.ResultUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class PersonnelAction extends ActionSupport {
	private PersonnelService personnelService;
	public void setPersonnelService(PersonnelService personnelService) {
		this.personnelService = personnelService;
	}

	public String execute() {
		return null;
	}

	public String createPersonnel() throws IOException {
		//personnelaction/createPersonnel?id=3&password=1&pname=黄三&major=1&pclass=1&role=3
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		System.out.println(param.get("pname"));
		String contentType = request.getHeader("Content-Type");
		String ID = ResultUtils.getPostParameter(param, "id",contentType);
		String Ppassword = ResultUtils.getPostParameter(param, "password",contentType);
		String Pname = ResultUtils.getPostParameter(param, "pname",contentType);
		String major = ResultUtils.getPostParameter(param, "major",contentType);
		String role = ResultUtils.getPostParameter(param, "role",contentType);
		String pclass = ResultUtils.getPostParameter(param, "pclass",contentType);

		Personnel personnel = new Personnel();
		personnel.setID(ID);
		personnel.setPpassword(Ppassword);
		personnel.setPname(Pname);
		personnel.setRole(Integer.parseInt(role));
		personnel.setPclass(Integer.parseInt(pclass));
		personnel.setMajor(Integer.parseInt(major));
		System.out.println(personnel.toString());
		personnelService.createPersonnel(personnel);

		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String deletePersonnelByName() throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = ResultUtils.getRequestParameter(request, "pname");
		Gson gson = new Gson();
		Map<String, String> rtn = gson.fromJson(ids,
				new TypeToken<Map<String, String>>() {
				}.getType());
		for (Entry<String, String> entry : rtn.entrySet()) {
			String id = entry.getValue();
			personnelService.deletePersonnelByName(id);
		}
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		return null;
	}

	public String deletePersonnelByID() throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = ResultUtils.getRequestParameter(request, "id");
		Gson gson = new Gson();
		Map<String, String> rtn = gson.fromJson(ids,
				new TypeToken<Map<String, String>>() {
				}.getType());
		for (Entry<String, String> entry : rtn.entrySet()) {
			String id = entry.getValue();
			personnelService.deletePersonnelByID(id);
		}
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		return null;
	}

	public String updatePersonnel() throws IOException {
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
		String Ppassword = ResultUtils.getPostParameter(param, "password");
		String Pname = ResultUtils.getPostParameter(param, "pname");
		String major = ResultUtils.getPostParameter(param, "major");
		String role = ResultUtils.getPostParameter(param, "role");
		String pclass = ResultUtils.getPostParameter(param, "pclass");

		Personnel personnel = new Personnel();
		personnel.setID(ID);
		personnel.setPpassword(Ppassword);
		personnel.setPname(Pname);
		personnel.setRole(Integer.parseInt(role));
		personnel.setPclass(Integer.parseInt(pclass));
		personnel.setMajor(Integer.parseInt(major));
		System.out.println(personnel.toString());
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			personnelService.updatePersonnel(personnel);
		} catch (IllegalStateException e) {
			map.put("state", e.toString());
			ResultUtils.toJson(response, map);
			return null;
		}
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAllPersonnel() throws IOException {
		/*
		 * HttpServletResponse response = ServletActionContext.getResponse();
		 * response.setHeader("Access-Control-Allow-Origin", "*"); //
		 * 允许哪些url可以跨域请求到本域 response.setHeader("Access-Control-Allow-Methods",
		 * "GET"); // 允许的请求方法，一般是GET,POST,PUT,DELETE,OPTIONS
		 * response.setHeader("Access-Control-Allow-Headers",
		 * "x-requested-with,content-type"); // 允许哪些请求
		 * response.setContentType("text/html;charset=utf-8");
		 */
		System.out.println("this is in personnel");
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<Personnel> list = (List<Personnel>) personnelService
				.getAllPersonnel();
		map.put("personnels", list);
		ResultUtils.toJson(response, map);
		return null;
	}
	
	public List getAllPersonnelHql() throws IOException {
		HttpServletResponse response = ResultUtils.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();

		List list = personnelService.getAllPersonnelHql();
		String[] parameters= {"ID","Ppassword","Pname","major","role","pclass"};
		List<Map<String, Object>> maplist = ResultUtils.setResults(list, parameters);//new ArrayList<Map<String, Object>>();
		
		map.put("personnels", maplist);
		ResultUtils.toJson(response, map);
		return null;
	}

	public Personnel getPersonnelByName() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String pname = ResultUtils.getRequestParameter(request, "pname");
		Personnel personnel = personnelService.getPersonnelByName(pname);
		map.put("personnel", personnel);
		ResultUtils.toJson(response, map);
		return null;
	}
	
	public Personnel getPersonnelByNameHql() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String pname = ResultUtils.getRequestParameter(request, "pname");
				
		List list = personnelService.getPersonnelByNameHql(pname);
		String[] parameters= {"ID","Ppassword","Pname","major","role","pclass"};
		List<Map<String, Object>> maplist = ResultUtils.setResults(list, parameters);//new ArrayList<Map<String, Object>>();
		
		map.put("personnel", maplist);
		ResultUtils.toJson(response, map);
		return null;
	}

	public Personnel getPersonnelByID() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = ResultUtils.getRequestParameter(request, "id");
		Personnel personnel = personnelService.getPersonnelByID(id);
		map.put("personnel", personnel);
		ResultUtils.toJson(response, map);
		return null;
	}
	
	public Personnel getPersonnelByIDHql() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = ResultUtils.getRequestParameter(request, "id");
				
		List list = personnelService.getPersonnelByIDHql(id);
		String[] parameters= {"ID","Ppassword","Pname","major","role","pclass"};
		List<Map<String, Object>> maplist = ResultUtils.setResults(list, parameters);//new ArrayList<Map<String, Object>>();
		
		map.put("personnel", maplist);
		ResultUtils.toJson(response, map);
		return null;
	}
}
