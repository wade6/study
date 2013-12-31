package com.alibaba.webx.study.app1.module.screen;

import com.alibaba.citrus.turbine.Context;

/**
 * freemarker 测试
 * 
 * 模板引擎配置在 webx-component-and-root.xml
 * @author zhaoyuan.lizy
 *
 */
public class Findex {
	
	public void execute(Context context) throws Exception {
		
		context.put("message", "freemarker Test");
	}

}
