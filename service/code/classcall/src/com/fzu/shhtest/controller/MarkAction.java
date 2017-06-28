package com.fzu.shhtest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fzu.shhtest.domain.CallTheRoll;
import com.fzu.shhtest.domain.CourseNameAndID;
import com.fzu.shhtest.domain.Mark;
import com.fzu.shhtest.service.MarkService;
import com.fzu.shhtest.utils.ResultUtils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class MarkAction extends ActionSupport {
	private MarkService markService;
	
	public void setMarkService(MarkService markService) {
		this.markService = markService;
	}
	public String execute() {
		return SUCCESS;
	}
	public String createMark() throws IOException {
		//courseName=离散数学&id=160327002&dailyScore=84&finalScore=91
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
		String ID = ResultUtils.getPostParameter(param, "id",contentType);
		String courseName = ResultUtils.getPostParameter(param, "courseName",contentType);
		String dailyScore = ResultUtils.getPostParameter(param, "dailyScore",contentType);
		String finalScore = ResultUtils.getPostParameter(param, "finalScore",contentType);
		
		CourseNameAndID courseNameAndID = new CourseNameAndID();
		courseNameAndID.setID(ID);
		courseNameAndID.setCourseName(courseName);
		Mark mark = new Mark();
		mark.setDailyScore(Double.parseDouble(dailyScore));
		mark.setFinalScore(Double.parseDouble(finalScore));
		mark.setCnameAndID(courseNameAndID);
		markService.createMark(mark);
		
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String deleteMarkByName() throws IOException {
		//http://localhost:8080/shhTest/markaction/deleteMarkByName
		//courseName=离散数学&id=160327003&dailyScore=84&finalScore=92
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
		String courseName = ResultUtils.getPostParameter(param, "courseName",contentType);
		markService.deleteMarkByName(courseName);
		
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String updateMark() throws IOException {
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
		String ID = ResultUtils.getPostParameter(param, "id",contentType);
		String courseName = ResultUtils.getPostParameter(param, "courseName",contentType);
		String dailyScore = ResultUtils.getPostParameter(param, "dailyScore",contentType);
		String finalScore = ResultUtils.getPostParameter(param, "finalScore",contentType);
		
		CourseNameAndID courseNameAndID = new CourseNameAndID();
		courseNameAndID.setID(ID);
		courseNameAndID.setCourseName(courseName);
		Mark mark = new Mark();
		mark.setDailyScore(Double.parseDouble(dailyScore));
		mark.setFinalScore(Double.parseDouble(finalScore));
		mark.setCnameAndID(courseNameAndID);
		markService.updateMark(mark);
		
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getAllMark() throws IOException {
		HttpServletResponse response = ResultUtils.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<Mark> list = (List<Mark>) markService.getAllMark();
		/*
		List<List<String>> templist = new ArrayList<List<String>>();
		Iterator it1 = list.iterator();
		while(it1.hasNext())
		{
			Mark tmark = (Mark)it1.next();
			//System.out.println(((Mark)it1.next()).getDailyScore());
			List<String> tl = new ArrayList<String>();
			tl.add(tmark.getCnameAndID().getID());
			tl.add(tmark.getCnameAndID().getCourseName());
			tl.add(tmark.getDailyScore()+"");
			tl.add(tmark.getFinalScore()+"");
			templist.add(tl);
		}
		String[] parameters= {"ID","courseName","dailyScore","finalScore"};
		List<Map<String, Object>> maplist = ResultUtils.setResults(templist, parameters);//new ArrayList<Map<String, Object>>();
		
		map.put("marks", maplist);
		
		
		
		*/
		map.put("marks", list);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getMarkByName() throws IOException {
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
		String courseName = ResultUtils.getPostParameter(param, "courseName",contentType);
		System.out.println("coursename:   "+courseName);
		List<Mark> marks = markService.getMarkByName(courseName);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("marks", marks);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getMarkByID() throws IOException {
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
		String ID = ResultUtils.getPostParameter(param, "id",contentType);
		List<Mark> marks = markService.getMarkByID(ID);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("marks", marks);
		ResultUtils.toJson(response, map);
		return null;
	}

	public Mark getMarkByNameAndID() throws IOException {
		//courseName=离散数学&id=160327000
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
		String ID = ResultUtils.getPostParameter(param, "id");
		String courseName = ResultUtils.getPostParameter(param, "courseName",contentType);
		Mark mark = markService.getMarkByNameAndID(courseName, ID);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mark", mark);
		ResultUtils.toJson(response, map);
		return null;
	}
}
