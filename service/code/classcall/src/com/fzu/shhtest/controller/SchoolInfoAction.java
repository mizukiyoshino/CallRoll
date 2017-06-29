package com.fzu.shhtest.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fzu.shhtest.domain.Personnel;
import com.fzu.shhtest.domain.SchoolInfo;
import com.fzu.shhtest.service.SchoolInfoService;
import com.fzu.shhtest.utils.ResultUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SchoolInfoAction extends ActionSupport {
	private SchoolInfoService schoolInfoService;

	public void setSchoolInfoService(SchoolInfoService schoolInfoService) {
		this.schoolInfoService = schoolInfoService;
	}
	public String execute() {
		return SUCCESS;
	}
	public String createSchoolInfo() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		//school=花椰菜大学&college=花椰菜学院&department=花椰菜系
		String school = ResultUtils.getPostParameter(param, "school");
		String college = ResultUtils.getPostParameter(param, "college");
		String department = ResultUtils.getPostParameter(param, "department");
		Date date = new Date();
		System.out.println(date.toString());
		String starttime = ""+(date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+date.getDate();
		SchoolInfo schoolInfo = new SchoolInfo();
		schoolInfo.setSchool(school);
		schoolInfo.setCollege(college);
		schoolInfo.setDepartment(department);
		schoolInfo.setStarttime(ResultUtils.stringToDate(starttime));
		schoolInfoService.createSchoolInfo(schoolInfo);
		
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}
	
	public String deleteSchoolInfo() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		schoolInfoService.deleteSchoolInfo();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}
	
	public String updateSchoolInfo() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String school = ResultUtils.getPostParameter(param, "school");
		String college = ResultUtils.getPostParameter(param, "college");
		String department = ResultUtils.getPostParameter(param, "department");
		String starttime = ResultUtils.getPostParameter(param, "starttime");
		SchoolInfo schoolInfo = new SchoolInfo();
		schoolInfo.setSchool(school);
		schoolInfo.setCollege(college);
		schoolInfo.setDepartment(department);
		schoolInfo.setStarttime(ResultUtils.stringToDate(starttime));
		schoolInfoService.updateSchoolInfo(schoolInfo);
		
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}
	
	public String getSchoolInfo() throws IOException{
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();

		SchoolInfo schoolInfo = schoolInfoService.getSchoolInfo();
		map.put("schoolInfo", schoolInfo);
		ResultUtils.toJson(response, map);
		return null;
	}
}
