package com.fzu.shhtest.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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

import com.google.gson.Gson;

public class ResultUtils {
	// 将对象封装成json，并返回给请求者
	public static void toJson(HttpServletResponse response, Object data)
			throws IOException {
		Gson gson = new Gson();
		String result = gson.toJson(data);
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Headers","X-Custom-Header,accept,x-requested-with,content-type"); // 允许哪些请求
		response.setHeader("Cache-Control", "no-cache"); // 取消浏览器缓存
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

	// 根据parameterName获取参数
	public static String getRequestParameter(HttpServletRequest request,
			String parameterName) throws UnsupportedEncodingException {
		// HttpServletRequest request = ServletActionContext.getRequest();
		String tempparameter = "";
		String parameter = "";
		try {
			tempparameter = request.getParameter(parameterName);
			parameter = new String(tempparameter.getBytes("ISO-8859-1"),
					"utf-8");
		} catch (Exception e) {
			return "";
		}
		return parameter;
	}

	// 根据parameterName获取POST提交的数据
	public static String getPostParameter(Map<String, String> params,
			String parameterName)
			throws UnsupportedEncodingException {
		// HttpServletRequest request = ServletActionContext.getRequest();
		String tempparameter = params.get(parameterName);
		String parameter = new String(tempparameter.getBytes("ISO-8859-1"),
				"utf-8");
		return tempparameter;
	}// 根据parameterName获取POST提交的数据

	public static String getPostParameter(Map<String, String> params,
			String parameterName, String haveHeader)
			throws UnsupportedEncodingException {
		// HttpServletRequest request = ServletActionContext.getRequest();
		String tempparameter = params.get(parameterName);//url
		String parameter = new String(tempparameter.getBytes("ISO-8859-1"),
				"utf-8");
		if(haveHeader == null)
			return parameter;
		return tempparameter;
	}

	// 设置Response的相关属性，以实现跨域请求
	public static HttpServletResponse setResponse(HttpServletResponse response) {
		// HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*"); // 允许哪些url可以跨域请求到本域
		response.setHeader("Access-Control-Allow-Methods", "*"); // 允许的请求方法，一般是GET,POST,PUT,DELETE,OPTIONS
		response.setHeader("Access-Control-Allow-Headers",
				"X-Custom-Header,accept,x-requested-with,content-type"); // 允许哪些请求
		response.setContentType("text/html;charset=utf-8");
		return response;
	}

	public static List<Map<String, Object>> setResults(List list,
			String parameters[]) {
		List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			Map<String, Object> tempmap = new HashMap<String, Object>();
			for (int j = 0; j < parameters.length; j++) {
				tempmap.put(parameters[j], String.valueOf(obj[j]));
			}
			/*
			 * String ID = String.valueOf(obj[0]); String ppassword =
			 * String.valueOf(obj[1]); String pname = String.valueOf(obj[2]);
			 * String dept = String.valueOf(obj[3]); int state =
			 * Integer.parseInt(String.valueOf(obj[4])); //Test test = new
			 * Test(ID, ppassword, pname, dept, state);
			 * 
			 * tempmap.put("ID", ID); tempmap.put("ppassword", ppassword);
			 * tempmap.put("pname", pname); tempmap.put("dept", dept);
			 * tempmap.put("state", state);
			 */
			maplist.add(tempmap);
			// System.out.println(""+id+"   "+brach+"   "+brachfather);
		}
		return maplist;
	}
	
	public static Date stringToDate(String stringDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = sdf.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static Date stringToDate(String stringDate,String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		try {
			date = sdf.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}