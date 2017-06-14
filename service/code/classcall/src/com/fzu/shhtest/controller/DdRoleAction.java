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
import com.fzu.shhtest.service.DdRoleService;
import com.fzu.shhtest.utils.ResultUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DdRoleAction extends ActionSupport {
	private DdRoleService ddRoleService;
	public void setDdRoleService(DdRoleService ddRoleService) {
		this.ddRoleService = ddRoleService;
	}
	public String execute() {
		return SUCCESS;
	}

	public String createDdRole() throws IOException {
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
		String role = ResultUtils.getPostParameter(param, "role");
		String state = new String("启用");
		DdRole ddRole = new DdRole();

		ddRole.setDname(dname);
		ddRole.setRole(Integer.parseInt(role));
		ddRole.setState(state);
		ddRoleService.createDdRole(ddRole);

		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String deleteDdRoleByName() throws IOException {
		//localhost:8080/shhTest/ddRoleaction/deleteDdRoleByName?dname=柯南
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = ResultUtils.getRequestParameter(request, "dname");
		Gson gson = new Gson();
		Map<String, String> rtn = gson.fromJson(ids,
				new TypeToken<Map<String, String>>() {
				}.getType());
		for (Entry<String, String> entry : rtn.entrySet()) {
			String id = entry.getValue();
			System.out.println("id   "+id);
			ddRoleService.deleteDdRoleByName(id);
		}
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getDdRoleStateByName() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String dname = ResultUtils.getRequestParameter(request, "dname");
		System.out.println("dname:  " + dname);
		DdRole ddRole = ddRoleService.getDdRoleStateByName(dname);
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ddRole", ddRole);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String updateDdRoleStateByName() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		//http://222.76.30.22:8080/shhTest/ddRoleaction/updateDdRoleStateByName
		//oldname=教师&dname=教师&role=4
		//application/x-www-form-urlencoded
		String contentType = request.getHeader("Content-Type");
		String oldname = ResultUtils.getPostParameter(param, "oldname",contentType);
		String dname = ResultUtils.getPostParameter(param, "dname",contentType);
		String role = ResultUtils.getPostParameter(param, "role",contentType);
		String state = new String("启用");
		DdRole ddRole = new DdRole();//.getDdRoleStateByName(oldname);
		System.out.println(oldname+"   "+dname+"        "+role);
		ddRole.setDname(dname);
		ddRole.setRole(Integer.parseInt(role));
		ddRole.setState(state);
		ddRoleService.updateDdRoleStateByName(ddRole,oldname);

		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1);
		ResultUtils.toJson(response, map);
		return null;
	}

	public String getAllDdRole() throws IOException {
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<DdRole> list = (List<DdRole>) ddRoleService.getAllDdRole();
		map.put("ddRoles", list);
		ResultUtils.toJson(response, map);
		return null;
	}
}