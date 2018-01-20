package com.tfss.sophia.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * HttpServletRequest增强类
 * 
 * @author tfss
 *
 */
public class Request {

	private HttpServletRequest request;
	
	public Request(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;
	}

	public HttpServletRequest getRaw() {
		return request;
	}
	/**
	 * 设置属性，供前端获取
	 * @param name : 属性，
	 * @param value：属性值，页面获取该值方法：${name}
	 */
	public void setAttribute(String name, Object value){
		request.setAttribute(name, value);
	}
	
	/**
	 * 获取属性值
	 * @param name：属性名
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getAttribute(String name){
		Object value = request.getAttribute(name);
		if(null != value){
			return (T) value;
		}
		return null;
	}
	/**
	 * 获取前端参数
	 * @param name：前端传过来的参数
	 * @return
	 */
	public String getParameter(String name){
		return request.getParameter(name);
	}
	/**
	 * 获取前端参数，并将其转化为整形 Integer
	 * @param name：前端传过来的参数
	 * @return
	 */
	public Integer getParameterAsInt(String name){
		String val = getParameter(name);
		if(null != val && !val.equals("")){
			return Integer.valueOf(val);
		}
		return null;
	}
	
	public String cookie(String name){
		Cookie[] cookies = request.getCookies();
		if(null != cookies && cookies.length > 0){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals(name)){
					return cookie.getValue();
				}
			}
		}
		return null;
	}
}
