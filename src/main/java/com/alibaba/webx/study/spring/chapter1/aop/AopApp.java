/**
 * Project: study
 * File Created at 2013-6-20下午11:00:48
 */
package com.alibaba.webx.study.spring.chapter1.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoyuanli 2013-6-20下午11:00:48
 */
public class AopApp {

    public static void main(String[] args) {
        //        BeanFactory factory = new XmlBeanFactory(new ClassPathResource(
        //                "com/alibaba/webx/study/spring/chapter1/aop/aop.xml"));
        ApplicationContext cxt = new ClassPathXmlApplicationContext(
                "com/alibaba/webx/study/spring/chapter1/aop/aop.xml");
        Knight knight = (Knight) cxt.getBean("knight");
        knight.embarkOnQuest();

    }

}
