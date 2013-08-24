package com.alibaba.webx.study.app1.module.screen.webjs;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;

public class AddOrder {
	
	@Resource
	private HttpSession session;

	public void execute(@Param("name") String name, Context context) throws Exception {
		
		session.setAttribute("test", "test cookie");
	}
}
