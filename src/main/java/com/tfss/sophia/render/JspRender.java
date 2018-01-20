package com.tfss.sophia.render;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tfss.sophia.Const;
import com.tfss.sophia.Sophia;
import com.tfss.sophia.SophiaContext;

/**
 * JSP渲染实现
 * @author tfss
 *
 */
public class JspRender implements Render{

	@Override
	public void render(String view, Writer writer) {
		
		String viewPath = this.getViewPath(view);
		
		HttpServletRequest servletRequest = SophiaContext.me().getRequest().getRaw();
		HttpServletResponse servletResponse = SophiaContext.me().getResponse().getRaw();
		try {
			servletRequest.getRequestDispatcher(viewPath).forward(servletRequest, servletResponse);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private String getViewPath(String view){
		Sophia sophia = Sophia.me();
		String viewPrfix = sophia.getConf(Const.VIEW_PREFIX_FIELD);
		String viewSuffix = sophia.getConf(Const.VIEW_SUFFIX_FIELD);

		if (null == viewSuffix || viewSuffix.equals("")) {
			viewSuffix = Const.VIEW_SUFFIX;
		}
		if (null == viewPrfix || viewPrfix.equals("")) {
			viewPrfix = Const.VIEW_PREFIX;
		}
		String viewPath = viewPrfix + "/" + view;
		if (!view.endsWith(viewSuffix)) {
			viewPath += viewSuffix;
		}
		return viewPath.replaceAll("[/]+", "/");
	}
}
