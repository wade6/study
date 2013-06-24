/**
 * Project: study
 * File Created at 2013-6-24下午8:47:08
 */
package com.alibaba.webx.study.spring.chapter3.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * @author zhaoyuanli
 * 2013-6-24下午8:47:08
 */
public class Person implements ApplicationContextAware {
    
    private ApplicationContext applicationContext;
    
    public  String name = "person name";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @author zhaoyuanli
     * 2013-6-24下午9:06:04
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    
    public String[] getBeanNames(){
        return this.applicationContext.getBeanDefinitionNames();
    }
    
}
