/**
 * Project: study
 * File Created at 2013-6-24下午8:48:26
 */
package com.alibaba.webx.study.spring.chapter3.beanpostprocessor;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自定义bean后处理和使用spring内置的后处理
 * @author zhaoyuanli
 * 2013-6-24下午8:48:26
 */
public class BeanPostApp {

    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext(
                "com/alibaba/webx/study/spring/chapter3/beanPostProcessor.xml");
        
        Person p = (Person)cxt.getBean("person");// name=person name
        System.out.println(p.getName());// 输出 PERSON NAME
        // spring 内置的ApplicationContextAwareProcessor
        System.out.println(ToStringBuilder.reflectionToString(p.getBeanNames()));
    }
}
