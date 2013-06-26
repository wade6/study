/**
 * Project: study
 * File Created at 2013-6-26下午10:42:15
 */
package com.alibaba.webx.study.spring.chapter5.ibatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author zhaoyuanli
 * 2013-6-26下午10:42:15
 */
public class IbatisApp {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "com/alibaba/webx/study/spring/chapter5/dataSource.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
        System.out.println(userDAO.insert());
    }
}
