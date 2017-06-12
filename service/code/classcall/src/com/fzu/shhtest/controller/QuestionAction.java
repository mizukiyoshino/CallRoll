package com.fzu.shhtest.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import com.fzu.shhtest.domain.Course;
import com.fzu.shhtest.domain.DdClassDate;
import com.fzu.shhtest.domain.Mark;
import com.fzu.shhtest.domain.Question;
import com.fzu.shhtest.service.MarkService;
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
	
	public String createQuestion() {
		
		return null;
	}

	public String deleteQuestion() {

		return null;
	}

	public String getQuestion() {

		return null;
	}

	public String updateQuestion() {
		return null;
	}
	
	public String getAllQuestion() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*"); // 允许哪些url可以跨域请求到本域
		response.setHeader("Access-Control-Allow-Methods", "GET"); // 允许的请求方法，一般是GET,POST,PUT,DELETE,OPTIONS
		response.setHeader("Access-Control-Allow-Headers",
				"x-requested-with,content-type"); // 允许哪些请求
		response.setContentType("text/html;charset=utf-8");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Question> list = (List<Question>)questionService.getAllQuestion();
		map.put("questions", list);
		ResultUtils.toJson(response, map);
		return null;
	}
}
