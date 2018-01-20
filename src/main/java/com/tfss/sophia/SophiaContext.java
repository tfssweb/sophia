package com.tfss.sophia;

import javax.servlet.ServletContext;

import com.tfss.sophia.servlet.Request;
import com.tfss.sophia.servlet.Response;



public class SophiaContext {
private static final ThreadLocal<SophiaContext> CONTEXT = new ThreadLocal<SophiaContext>();
	
	private ServletContext context;
	private Request request;
	private Response response;
	
	public SophiaContext() {
		
	}
	
	public static SophiaContext me(){
		return CONTEXT.get();
	}
	
	public static void initContext(ServletContext context, Request request, Response response) {
		SophiaContext sophiaContext = new SophiaContext();
		sophiaContext.context = context;
		sophiaContext.request = request;
		sophiaContext.response = response;
    	CONTEXT.set(sophiaContext);
    }
    
    public static void remove(){
    	CONTEXT.remove();
    }
	
	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
}
