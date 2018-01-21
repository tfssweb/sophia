package com.tfss.sophia.demo.controller;

import com.tfss.sophia.servlet.Request;
import com.tfss.sophia.servlet.Response;

public class IndexController {

	public void index(Request request,Response response){
		request.setAttribute("name", "tfss");
		response.render("index");
	}
}
