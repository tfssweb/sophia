package com.tfss.sophia.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.tfss.sophia.Sophia;
import com.tfss.sophia.render.Render;

/**
 * HttpServletResponse增强类
 * @author tfss
 *
 */
public class Response {

	private HttpServletResponse response;
	
	private Render render = null;
	
	public Response(HttpServletResponse httpServletResponse) {
		this.response = httpServletResponse;
		this.response.setHeader("Framework", "sophia");
		this.render = Sophia.me().getRender();
	}
	
	public void text(String text) {
		response.setContentType("text/plan;charset=UTF-8");
		this.print(text);
	}

	public void html(String html) {
		response.setContentType("text/html;charset=UTF-8");
		this.print(html);
	}
	
	private void print(String str){
		try {
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(str.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cookie(String name, String value){
		Cookie cookie = new Cookie(name, value);
		response.addCookie(cookie);
	}
	
	public HttpServletResponse getRaw() {
		return response;
	}
	
	public void render(String view) {
		render.render(view, null);
	}

	public void redirect(String location) {
		try {
			response.sendRedirect(location);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
