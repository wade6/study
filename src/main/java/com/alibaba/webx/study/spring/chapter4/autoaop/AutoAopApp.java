/**
 * Project: study
 * File Created at 2013-6-25下午11:18:59
 */
package com.alibaba.webx.study.spring.chapter4.autoaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author zhaoyuanli
 * 2013-6-25下午11:18:59
 */
public class AutoAopApp {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "com/alibaba/webx/study/spring/chapter4/aop.xml");
        Person p = (Person) ctx.getBean("person");
        p.doThing();
    }
}
