/**
 * Project: study
 * File Created at 2013-6-25下午11:18:59
 */
package com.alibaba.webx.study.spring.chapter4.aop.proxyaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.webx.study.spring.chapter4.aop.Person;

/**
 * 使用代理类生成aop的通知代理
 * 
 * @author zhaoyuanli
 * 2013-6-25下午11:18:59
 */
public class ProxyAopApp {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "com/alibaba/webx/study/spring/chapter4/aop/proxyaop/proxyAop.xml");
        Person p = (Person) ctx.getBean("person");
        p.doThing();
    }
}
