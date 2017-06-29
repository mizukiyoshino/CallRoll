package com.fzu.shhtest.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
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
	public String createMark() {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	public String deleteMarkByName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateMark() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAllMark() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*"); // 允许哪些url可以跨域请求到本域
		response.setHeader("Access-Control-Allow-Methods", "GET"); // 允许的请求方法，一般是GET,POST,PUT,DELETE,OPTIONS
		response.setHeader("Access-Control-Allow-Headers",
				"x-requested-with,content-type"); // 允许哪些请求
		response.setContentType("text/html;charset=utf-8");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Mark> list = (List<Mark>) markService
				.getAllMark();
		map.put("marks", list);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getMarkByName() throws IOException {
		// TODO Auto-generated method stub
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*"); // 允许哪些url可以跨域请求到本域
		response.setHeader("Access-Control-Allow-Methods", "GET"); // 允许的请求方法，一般是GET,POST,PUT,DELETE,OPTIONS
		response.setHeader("Access-Control-Allow-Headers",
				"x-requested-with,content-type"); // 允许哪些请求
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> map = new HashMap<String, Object>();
		String tempcname = "";
		String cname = "";
		try {
			tempcname = request.getParameter("cname");

		} catch (Exception e) {
			// TODO: handle exception
			map.put("marks", "null");
			ResultUtils.toJson(response, map);
			return null;
		}
		if (tempcname != null) {
			cname = new String(tempcname.getBytes("ISO-8859-1"), "utf-8");

			List<Mark> list = (List<Mark>) markService
					.getMarkByName(cname);
			map.put("marks", list);
			ResultUtils.toJson(response, map);
		} else {
			map.put("marks", "null");
			ResultUtils.toJson(response, map);
			return null;
		}
		return null;
	}

	public String getMarkByID() {
		// TODO Auto-generated method stub
		return null;
	}

	public Mark getMarkByNameAndID() {
		// TODO Auto-generated method stub
		return null;
	}
}
