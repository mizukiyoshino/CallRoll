package com.fzu.shhtest.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fzu.shhtest.domain.DdRole;
import com.fzu.shhtest.domain.Question;
import com.fzu.shhtest.service.QuestionService;
import com.fzu.shhtest.utils.ResultUtils;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class QuestionAction extends ActionSupport {
	private QuestionService questionService;
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	public String execute() {
		return SUCCESS;
	}

	public String createQuestion() throws IOException {
		//http://localhost:8080/shhTest/questionaction/createQuestion
		//attendanceDate=2017-06-15&score=82.2&ID=160327000&courseName=离散数学
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		Date attendanceDate = new Date();
		String contentType = request.getHeader("Content-Type");
		String score = ResultUtils.getPostParameter(param, "score",contentType);
		String ID = ResultUtils.getPostParameter(param, "ID",contentType);
		String courseName = ResultUtils.getPostParameter(param, "courseName",contentType);

		Question question = new Question();
		question.setCourseName(courseName);
		question.setID(ID);
		question.setAttendanceDate(attendanceDate);
		question.setScore(Double.parseDouble(score));
		
		questionService.createQuestion(question);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String deleteQuestionByCourseName() throws IOException {
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
		System.out.println("courseName    "+courseName);
		questionService.deleteQuestionByCourseName(courseName);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String deleteQuestionByCoursenameAndID() throws IOException {
		//http://localhost:8080/shhTest/questionaction/deleteQuestionByCoursenameAndID
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
		String courseName = ResultUtils.getPostParameter(param, "courseName",contentType);
		String ID = ResultUtils.getPostParameter(param, "id");
		System.out.println(courseName+"    "+ID);
		questionService.deleteQuestionByCoursenameAndID(courseName,ID);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String deleteQuestionByCoursenameAndIDAndDate() throws IOException {
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
		String ID = ResultUtils.getPostParameter(param, "id",contentType);
		String attendanceDate = ResultUtils.getPostParameter(param, "attendanceDate",contentType);
		Date date = ResultUtils.stringToDate(attendanceDate);
		questionService.deleteQuestionByCoursenameAndIDAndDate(courseName, ID, date);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}
	//存在问题
	public String updateQuestionByCoursenameAndIDAndDate() throws IOException {
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
		String ID = ResultUtils.getPostParameter(param, "id",contentType);
		String attendanceDate = ResultUtils.getPostParameter(param, "attendanceDate",contentType);
		Date date = ResultUtils.stringToDate(attendanceDate);
		
		questionService.deleteQuestionByCoursenameAndIDAndDate(courseName, ID, date);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getAllQuestion() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<Question> list = (List<Question>) questionService.getAllQuestion();
		map.put("questions", list);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getQuestionByCourseName() throws IOException {
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
		List questions=(ArrayList<Question>)questionService.getQuestionByCourseName(courseName);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("questions", questions);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getQuestionByID() throws IOException {
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
		List questions=(ArrayList<Question>)questionService.getQuestionByID(ID);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("questions", questions);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getQuestionByCoursenameAndID() throws IOException {
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
		String ID = ResultUtils.getPostParameter(param, "id",contentType);
		List questions=(ArrayList<Question>)questionService.getQuestionByCoursenameAndID(courseName,ID);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("questions", questions);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getQuestionByCoursenameAndIDAndDate() throws IOException {
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
		String ID = ResultUtils.getPostParameter(param, "id",contentType);
		String attendanceDate = ResultUtils.getPostParameter(param, "attendanceDate",contentType);
		Date date = ResultUtils.stringToDate(attendanceDate);
		List<Question> questions=questionService.getQuestionByCoursenameAndIDAndDate(courseName,ID,date);
		HttpServletResponse response = ResultUtils.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("questions", questions);
		ResultUtils.toJson(response, map);
		return null;
	}
}
