/**
 * Project: study
 * File Created at 2013-6-25下午11:35:39
 */
package com.alibaba.webx.study.spring.chapter4.aop.anotationaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.webx.study.spring.chapter4.aop.Person;

/**
 * 使用aspectJ注释实现切面，配置文件需要 <aop:aspectj-autoproxy />
 * 
 * @author zhaoyuanli
 * 2013-6-25下午11:35:39
 */
public class AnotationAopApp {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "com/alibaba/webx/study/spring/chapter4/aop/anotationaop/anotationAop.xml");
        Person p = (Person) ctx.getBean("person");
        p.doThing();
    }

}
