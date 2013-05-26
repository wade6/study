package com.alibaba.webx.study.my.timetask.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringQuartzDemo {
    
    /**
     * 有两种流行Spring定时器配置：Java的Timer类和OpenSymphony的Quartz。<p>
     * 
     * Quartz
     * 
     * @author zhaoyuanli
     * 2013-5-23下午11:48:35
     */
    public static void main(String[] args) {
        
        ApplicationContext cxt = new ClassPathXmlApplicationContext("com/alibaba/webx/study/my/timetask/spring/spring-quartz-bean.xml");
        System.out.println("******SpringQuartzDemo ok!");
    }

}
