package com.fzu.shhtest.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.dialect.Ingres10Dialect;

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
	public String getAllPersonnel() throws IOException {
		/*
		 * HttpServletResponse response = ServletActionContext.getResponse();
		 * response.setHeader("Access-Control-Allow-Origin", "*"); //
		 * 允许哪些url可以跨域请求到本域 response.setHeader("Access-Control-Allow-Methods",
		 * "GET"); // 允许的请求方法，一般是GET,POST,PUT,DELETE,OPTIONS
		 * response.setHeader("Access-Control-Allow-Headers",
		 * "x-requested-with,content-type"); // 允许哪些请求
		 * response.setContentType("text/html;charset=utf-8");
		 */
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List<Personnel> list = (List<Personnel>) personnelService
				.getAllPersonnel();
		map.put("personnels", list);
		ResultUtils.toJson(response, map);
		return null;
	}
	
	public String getAllPersonnelHql() throws IOException {
		HttpServletResponse response = ResultUtils.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		List list = personnelService.getAllPersonnelHql();
		String[] parameters= {"ID","Ppassword","Pname","major","role","pclass"};
		List<Map<String, Object>> maplist = ResultUtils.setResults(list, parameters);//new ArrayList<Map<String, Object>>();
		map.put("personnels", maplist);
		ResultUtils.toJson(response, map);
		
		
		
		
		/*
		 * 产生INSERT INTO calltheroll (courseName,ID,callstate,calldate,callposition) VALUES ('机器学习理论','160327149',3,'2017-3-2','6*4');
		int j=0;
		Random random=new Random();
		int[] ran= {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,3,3,3,3,4};
		
		for(int i=9; i<=55; i++){
			int q = j;
			int k = i%9;
			System.out.println("INSERT INTO calltheroll (courseName,ID,callstate,calldate,callposition) VALUES ('机器学习理论','1603271"+(i+1)+"',"+ran[random.nextInt(ran.length)]+",'2017-3-2','"+(q+1) +"*"+(k+1)+ "');");
			System.out.println("INSERT INTO calltheroll (courseName,ID,callstate,calldate,callposition) VALUES ('机器学习理论','1603271"+(i+1)+"',"+ran[random.nextInt(ran.length)]+",'2017-3-9','"+(q+1) +"*"+(k+1)+ "');");
			System.out.println("INSERT INTO calltheroll (courseName,ID,callstate,calldate,callposition) VALUES ('机器学习理论','1603271"+(i+1)+"',"+ran[random.nextInt(ran.length)]+",'2017-3-16','"+(q+1) +"*"+(k+1)+ "');");
			System.out.println("INSERT INTO calltheroll (courseName,ID,callstate,calldate,callposition) VALUES ('机器学习理论','1603271"+(i+1)+"',"+ran[random.nextInt(ran.length)]+",'2017-3-23','"+(q+1) +"*"+(k+1)+ "');");
			System.out.println("INSERT INTO calltheroll (courseName,ID,callstate,calldate,callposition) VALUES ('机器学习理论','1603271"+(i+1)+"',"+ran[random.nextInt(ran.length)]+",'2017-3-30','"+(q+1) +"*"+(k+1)+ "');");
			System.out.println("INSERT INTO calltheroll (courseName,ID,callstate,calldate,callposition) VALUES ('机器学习理论','1603271"+(i+1)+"',"+ran[random.nextInt(ran.length)]+",'2017-4-6','"+(q+1) +"*"+(k+1)+ "');");
			System.out.println("INSERT INTO calltheroll (courseName,ID,callstate,calldate,callposition) VALUES ('机器学习理论','1603271"+(i+1)+"',"+ran[random.nextInt(ran.length)]+",'2017-4-13','"+(q+1) +"*"+(k+1)+ "');");
			System.out.println("INSERT INTO calltheroll (courseName,ID,callstate,calldate,callposition) VALUES ('机器学习理论','1603271"+(i+1)+"',"+ran[random.nextInt(ran.length)]+",'2017-4-20','"+(q+1) +"*"+(k+1)+ "');");
			System.out.println("INSERT INTO calltheroll (courseName,ID,callstate,calldate,callposition) VALUES ('机器学习理论','1603271"+(i+1)+"',"+ran[random.nextInt(ran.length)]+",'2017-4-27','"+(q+1) +"*"+(k+1)+ "');");
			System.out.println("INSERT INTO calltheroll (courseName,ID,callstate,calldate,callposition) VALUES ('机器学习理论','1603271"+(i+1)+"',"+ran[random.nextInt(ran.length)]+",'2017-5-4','"+(q+1) +"*"+(k+1)+ "');");
			System.out.println("INSERT INTO calltheroll (courseName,ID,callstate,calldate,callposition) VALUES ('机器学习理论','1603271"+(i+1)+"',"+ran[random.nextInt(ran.length)]+",'2017-5-11','"+(q+1) +"*"+(k+1)+ "');");
			System.out.println("INSERT INTO calltheroll (courseName,ID,callstate,calldate,callposition) VALUES ('机器学习理论','1603271"+(i+1)+"',"+ran[random.nextInt(ran.length)]+",'2017-5-18','"+(q+1) +"*"+(k+1)+ "');");
			System.out.println();
			if(k==8 && i!=0)
				++j;
		}
		*/
		
		/*
		 * 产生INSERT INTO question (attendanceDate,score,ID,courseName) VALUES ('2017-3-23',81,'160327109','机器学习理论');
		int j=0;
		Random random=new Random();
		String[] dates = {"2017-3-2","2017-3-9","2017-3-16","2017-3-23","2017-3-30","2017-4-6","2017-4-13",
				"2017-4-20","2017-4-26","2017-5-4","2017-5-11","2017-5-18","2017-5-25","2017-6-2","2017-6-9","2017-6-16"};
		
		int[][] ran_dates={{1,5,7,8,12},{2,7,9,15},{3,4,7,9,14,15},{4,7,9,10},{3,5,6,12}
						,{1,4,7,9,11},{3,8,15},{2,4,6,8,11},{2,3,4,8,9,14,15}};
		
		for(int i=10; i<=55; i++){
			int k = random.nextInt(ran_dates.length);
			for(int t=0; t<ran_dates[k].length; t++)
			{
				System.out.println("INSERT INTO question (attendanceDate,score,ID,courseName) VALUES ('"+dates[ran_dates[k][t]]+"',"+(70+random.nextInt(30))+",'1603271"+i+"','机器学习理论');");	
			}
			System.out.println();
		}
		*/
		
		return null;
	}
	
	public String getPersonnelByName() throws IOException {
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
	
	public String CheckPersonnel() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>();

		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				param.put(key, values[i]);
			}
		}
		System.out.println("in check1");
		String contentType = request.getHeader("Content-Type");
		String ID = ResultUtils.getPostParameter(param, "id",contentType);
		System.out.println("in check2");
		String Ppassword = ResultUtils.getPostParameter(param, "password",contentType);
		Personnel personnel = personnelService.getPersonnelByID(ID);
		System.out.println("in check3");
		HttpServletResponse response = ResultUtils
				.setResponse(ServletActionContext.getResponse());
		Map<String, Object> map = new HashMap<String, Object>();
		if(personnel == null)
		{
			map.put("state", "0");//用户不存在
		}
		else if (!personnel.getPpassword().equals(Ppassword)) {
			map.put("state", "-1");//密码不正确
		}
		else{
			map.put("state", "1");//登陆成功
		}
		ResultUtils.toJson(response, map);
		return null;
	}
	
	public String getPersonnelByNameHql() throws IOException {
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
		List<Personnel> personnels = new ArrayList<Personnel>();
		personnels.add(personnel);
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
