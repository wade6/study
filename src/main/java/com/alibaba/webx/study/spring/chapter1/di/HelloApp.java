/**
 * Project: study
 * File Created at 2013-6-20下午10:24:16
 */
package com.alibaba.webx.study.spring.chapter1.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.citrus.springext.support.context.XmlBeanFactory;

/**
 * 注意：使用ClassPathResource时，参数为类路径，不用加classPath<p>
 * System.getProperty("java.class.path");
 * @author zhaoyuanli 2013-6-20下午10:24:16
 */
public class HelloApp {

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource(
                "com/alibaba/webx/study/spring/chapter1/di/hello.xml"));
        GreetingService greeting = (GreetingService) factory.getBean("greetingService");
        greeting.sayGreeting();
    }
}
