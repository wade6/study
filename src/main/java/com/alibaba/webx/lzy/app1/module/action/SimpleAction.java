package com.alibaba.webx.lzy.app1.module.action;

import org.apache.log4j.Logger;

import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.webx.lzy.app1.study.classloader.userclassloader.SimpleObject;

public class SimpleAction {
	
	private static Logger logger = Logger.getLogger(SimpleAction.class);
	
    public void doGreeting(@FormGroup("simple") SimpleObject simple, Navigator nav) {
        String name = simple.getName();
        logger.error("打出日志====>NAME:"+name);
        nav.redirectTo("app1Link").withTarget("hello").withParameter("name", name);
    }
    
}
