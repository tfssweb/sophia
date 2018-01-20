package com.tfss.sophia.route;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.tfss.sophia.util.PathUtil;



/**
 * 路由匹配器
 * @author tfss
 *
 */
public class RouteMatcher {
	private List<Router> routes;

	public RouteMatcher(List<Router> routes) {
		this.routes = routes;
	}
	
	public void setRoutes(List<Router> routes) {
		this.routes = routes;
	}
	
	/**
	 * 根据path查找路由
	 * @param path	请求地址
	 * @return		返回查询到的路由
	 */
	public Router findRoute(String path) {
		String cleanPath = parsePath(path);
		List<Router> matchRoutes = new ArrayList<Router>();
		for (Router route : this.routes) {
			if (matchesPath(route.getPath(), cleanPath)) {
				matchRoutes.add(route);
			}
		}
		// 优先匹配原则
        giveMatch(path, matchRoutes);
        
        return matchRoutes.size() > 0 ? matchRoutes.get(0) : null;
	}
	
	private void giveMatch(final String uri, List<Router> routes) {
		Collections.sort(routes, new Comparator<Router>() {
			@Override
			public int compare(Router o1, Router o2) {
				if (o2.getPath().equals(uri)) {
					return o2.getPath().indexOf(uri);
				}
				return -1;
			}
		});
	}
	
	private boolean matchesPath(String routePath, String pathToMatch) {
		routePath = routePath.replaceAll(PathUtil.VAR_REGEXP, PathUtil.VAR_REPLACE);
		return pathToMatch.matches("(?i)" + routePath);
	}

	private String parsePath(String path) {
		path = PathUtil.fixPath(path);
		try {
			URI uri = new URI(path);
			return uri.getPath();
		} catch (URISyntaxException e) {
			return null;
		}
	}
}
