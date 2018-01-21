package com.tfss.sophia.router;

import java.lang.reflect.Method;

/**
 * 路由
 * @author tfss
 *
 */
public class Router {

	/**
	 * 路由path
	 */
	private String path;
	
	/**
	 * 执行路由的方法
	 */
	private Method action;
	
	/**
	 * 路由所在的控制器
	 */
	private Object controller;
	
	public Router() {
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the action
	 */
	public Method getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(Method action) {
		this.action = action;
	}

	/**
	 * @return the controller
	 */
	public Object getController() {
		return controller;
	}

	/**
	 * @param controller the controller to set
	 */
	public void setController(Object controller) {
		this.controller = controller;
	}
	
	
}
