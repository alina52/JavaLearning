package com.binbin.utils;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class ResponseUtils {

	public static void write(HttpServletResponse response,Object object) throws Exception
	{
		response.setContentType("text/plain;charset=utf-8");
		response.getWriter().print(object.toString());
		response.getWriter().flush();
		response.getWriter().close();
		
	}
	
	public static JSONObject resultBean(boolean isSuccess, String message, Object bean, int errorCode){
		
		JSONObject object = new JSONObject();
		object.put("success", isSuccess);
		object.put("message", message);
		object.put("data", bean);
		object.put("errorCode", errorCode);
		
		return object;
	}
	
	public static <T> JSONObject resultBean(boolean isSuccess, String message, List<T> list, int errorCode){
		
		JSONObject object = new JSONObject();
		object.put("success", isSuccess);
		object.put("message", message);
		object.put("data", list);
		object.put("errorCode", errorCode);
		
		return object;
	}
	
}
