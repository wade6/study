/**
 * Project: study
 * File Created at 2013-6-24上午10:57:58
 */
package com.alibaba.webx.study.spring.chapter3.beanpostprocessor;

import java.lang.reflect.Field;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 对所有bean的name属性进行首字母大写处理的后处理器
 * 
 * @author zhaoyuanli
 * 2013-6-24上午10:57:58
 */
public class UpperCaseNameProcessor implements BeanPostProcessor {

    /**
     * @author zhaoyuanli
     * 2013-6-24上午10:58:23
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    /**
     * @author zhaoyuanli
     * 2013-6-24上午10:58:23
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        Field[] fielTds = bean.getClass().getFields();
        for(Field f : fielTds){
            if(f.getName().equals("name")&&f.getType().equals(String.class)){
                f.setAccessible(true);
                try {
                    String orignal=(String)f.get(bean);
                    f.set(bean, orignal.toUpperCase());
                } catch (IllegalArgumentException e) {
                } catch (IllegalAccessException e) {
                }
            }
        }
        return bean;
    }
    
    public static void main(String[] args) {
        String str="name";
        System.out.println(WordUtils.capitalize(str));
    }

}
