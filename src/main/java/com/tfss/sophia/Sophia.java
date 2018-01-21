package com.tfss.sophia;

import java.lang.reflect.Method;

import com.tfss.sophia.config.ConfigLoader;
import com.tfss.sophia.render.JspRender;
import com.tfss.sophia.render.Render;
import com.tfss.sophia.router.Routers;
import com.tfss.sophia.servlet.Request;
import com.tfss.sophia.servlet.Response;


/**
 * 
 * @author tfss
 *
 */
public class Sophia {
	/**
	 * 存放所有路由
	 */
	private Routers routers;
	
	/**
	 * 配置加载器
	 */
	private ConfigLoader configLoader;
	
	/**
	 * 框架是否已经初始化
	 */
	private boolean init = false;
	
	/**
	 * 渲染器
	 */
	private Render render;
	
	private Sophia() {
		routers = new Routers();
		configLoader = new ConfigLoader();
		render = new JspRender();
	}
	
	public boolean isInit() {
		return init;
	}

	public void setInit(boolean init) {
		this.init = init;
	}
	
	private static class SophiaHolder {
		private static Sophia ME = new Sophia();
	}
	
	public static Sophia me(){
		return SophiaHolder.ME;
	}
	
	public Sophia loadConf(String conf){
		configLoader.load(conf);
		return this;
	}
	
	public Sophia setConf(String name, String value){
		configLoader.setConf(name, value);
		return this;		 
	}
	
	public String getConf(String name){
		return configLoader.getConf(name);
	}
	
	public Sophia addRoutes(Routers routers){
		this.routers.addRouters(routers.getRouters());
		return this;
	}

	public Routers getRouters() {
		return routers;
	}
	
	/**
	 * 添加路由
	 * @param path			映射的PATH
	 * @param methodName	方法名称
	 * @param controller	控制器对象
	 * @return				返回Mario
	 */
	public Sophia addRouter(String path, String methodName, Object controller){
		try {
			Method method = controller.getClass().getMethod(methodName, Request.class, Response.class);
			this.routers.addRouter(path, method, controller);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return this;
	}

	public Render getRender() {
		return render;
	}

	public void setRender(Render render) {
		this.render = render;
	}
}
