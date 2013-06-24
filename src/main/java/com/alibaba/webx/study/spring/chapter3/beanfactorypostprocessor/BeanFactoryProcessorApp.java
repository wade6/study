/**
 * Project: study
 * File Created at 2013-6-24下午9:23:10
 */
package com.alibaba.webx.study.spring.chapter3.beanfactorypostprocessor;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用属性文件进行配置
 * @author zhaoyuanli
 * 2013-6-24下午9:23:10
 */
public class BeanFactoryProcessorApp {

    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext(
                "com/alibaba/webx/study/spring/chapter3/beanPostProcessor.xml");
        
        Person2 p = (Person2)cxt.getBean("person2");
        System.out.println("**************");
        System.out.println(ToStringBuilder.reflectionToString(p));
    }
}
