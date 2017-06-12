package com.fzu.shhtest.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.service.CourseService;
import com.fzu.shhtest.service.DdClassDateService;
import com.fzu.shhtest.utils.ResultUtils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CourseAction extends ActionSupport {
	private CourseService courseService;
	private DdClassDateService ddClassDateService;
	
	public void setDdClassDateService(DdClassDateService ddClassDateService) {
		this.ddClassDateService = ddClassDateService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public String execute() {
		return SUCCESS;
	}

	public String createCourse() throws IOException {
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
		String contentType = request.getHeader("Content-Type");
		String courseName = ResultUtils.getPostParameter(param, "coursename",contentType);
		String dailyWeight = ResultUtils.getPostParameter(param, "dailyweight",contentType);
		String finalWeight = ResultUtils.getPostParameter(param, "finalweight",contentType);
		String picketLine = ResultUtils.getPostParameter(param, "picketline",contentType);
		String classSession = ResultUtils.getPostParameter(param, "classsession",contentType);
		String classLocation = ResultUtils.getPostParameter(param, "classlocation",contentType);
		String classDate = ResultUtils.getPostParameter(param, "classdate",contentType);
		String classOrder = ResultUtils.getPostParameter(param, "classorder",contentType);
		String ID = ResultUtils.getPostParameter(param, "id",contentType);
		String shape = ResultUtils.getPostParameter(param, "shape",contentType);
		
		Course course = new Course();
		course.setCourseName(courseName);
		course.setDailyWeight(Double.parseDouble(dailyWeight));
		course.setFinalWeight(Double.parseDouble(finalWeight));
		course.setPicketLine(Integer.parseInt(picketLine));
		course.setClassSession(classSession);
		course.setClassLocation(classLocation);
		course.setClassDate(Integer.parseInt(classDate));
		course.setClassOrder(classOrder);
		course.setID(ID);
		course.setShape(shape);
		System.out.println(course.toString());
		courseService.createCourse(course);
		
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String deleteCourseByName() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cname = ResultUtils.getRequestParameter(request, "coursename");
		Map<String, Object> map = new HashMap<String, Object>();
		courseService.deleteCourseByName(cname);
		map.put("state", 1);
		HttpServletResponse response = ResultUtils.setResponse(ServletActionContext.getResponse());
		ResultUtils.toJson(response, map);
		return null;
	}

	public String updateCourse() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		String oldcourseName = ResultUtils.getPostParameter(param, "oldcoursename");
		System.out.println("oldcourseName is : "+oldcourseName);
		String courseName = ResultUtils.getPostParameter(param, "coursename");
		String dailyWeight = ResultUtils.getPostParameter(param, "dailyweight");
		String finalWeight = ResultUtils.getPostParameter(param, "finalweight");
		String picketLine = ResultUtils.getPostParameter(param, "picketline");
		String classSession = ResultUtils.getPostParameter(param, "classsession");
		String classLocation = ResultUtils.getPostParameter(param, "classlocation");
		String classDate = ResultUtils.getPostParameter(param, "classdate");
		String classOrder = ResultUtils.getPostParameter(param, "classorder");
		String ID = ResultUtils.getPostParameter(param, "id");
		String shape = ResultUtils.getPostParameter(param, "shape");
		System.out.println("courseName is : "+courseName);
		
		Course course = courseService.getCourseByName(oldcourseName);
		System.out.println("update course0 :"+course);
		course.setCourseName(courseName);
		course.setDailyWeight(Double.parseDouble(dailyWeight));
		course.setFinalWeight(Double.parseDouble(finalWeight));
		course.setPicketLine(Integer.parseInt(picketLine));
		course.setClassSession(classSession);
		course.setClassLocation(classLocation);
		course.setClassDate(Integer.parseInt(classDate));
		//DdClassDate ddClassDate = ddClassDateService.getDdClassDateStateByValue(Integer.parseInt(classDate));
		//course.setDdClassDate(ddClassDate);
		course.setClassOrder(classOrder);
		course.setID(ID);
		course.setShape(shape);
		courseService.updateCourse(course,oldcourseName);
		System.out.println("update course :"+course);
		
		
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getAllCourse() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> list = (List<Course>) courseService.getAllCourse();
		map.put("courses", list);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getCourseByName() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cname = ResultUtils.getRequestParameter(request, "coursename");
		Map<String, Object> map = new HashMap<String, Object>();
		Course course = courseService
				.getCourseByName(cname);
		map.put("course", course);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		ResultUtils.toJson(response, map);
		return null;
	}
}
