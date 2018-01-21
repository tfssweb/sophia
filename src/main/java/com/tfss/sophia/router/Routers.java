package com.tfss.sophia.router;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 * 存放所有路由
 * @author tfss
 *
 */
public class Routers {

	private static final Logger LOGGER = Logger.getLogger(Routers.class.getName());
	private List<Router> routers = new ArrayList<Router>();
	
	public Routers() {
	}
	
	public void addRouters(List<Router> routers){
		routers.addAll(routers);
	}
	
	public void addRouter(Router router){
		routers.add(router);
	}
	
	public void removeRouter(Router router){
		routers.remove(router);
	}
	
	public void addRouter(String path, Method action, Object controller){
		Router router = new Router();
		router.setPath(path);
		router.setAction(action);
		router.setController(controller);
		
		routers.add(router);
		LOGGER.info("Add Router：[" + path + "]");
	}

	public List<Router> getRouters() {
		return routers;
	}

	public void setRouters(List<Router> routers) {
		this.routers = routers;
	}
}
