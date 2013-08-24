/**
 * Project: study
 * File Created at 2013-6-25下午11:49:08
 */
package com.alibaba.webx.study.spring.chapter4.aop.autoproxyaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.webx.study.spring.chapter4.aop.Person;

/**
 * 使用spring的配置元素 <aop:aspectj-autoproxy /> 实现aop代理自动实现
 * 
 * @author zhaoyuanli
 * 2013-6-25下午11:49:08
 */
public class AutoProxyAopApp {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "com/alibaba/webx/study/spring/chapter4/aop/autoproxyaop/autoProxyAop.xml");
        Person p = (Person) ctx.getBean("person");
        p.doThing();
        p.doThing("test");
    }
}
