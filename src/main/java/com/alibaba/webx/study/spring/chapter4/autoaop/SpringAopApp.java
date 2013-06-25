/**
 * Project: study
 * File Created at 2013-6-25下午11:49:08
 */
package com.alibaba.webx.study.spring.chapter4.autoaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用spring的配置元素实现切面
 * @author zhaoyuanli
 * 2013-6-25下午11:49:08
 */
public class SpringAopApp {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "com/alibaba/webx/study/spring/chapter4/autoaop/springAop.xml");
        Person p = (Person) ctx.getBean("person");
        p.doThing();
    }
}
