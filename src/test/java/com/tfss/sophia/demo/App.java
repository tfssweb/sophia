package com.tfss.sophia.demo;

import com.tfss.sophia.Bootstrap;
import com.tfss.sophia.Sophia;
import com.tfss.sophia.demo.controller.IndexController;

/**
 * 测试类：应该实现Bootstrap 接口
 * @author tfss
 *
 */
public class App implements Bootstrap{

	@Override
	public void init(Sophia sophia) {

		IndexController indexController = new IndexController();
		sophia.addRouter("/", "index", indexController);
	}
	
	
}