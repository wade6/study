/**
 * Project: study
 * File Created at 2013-6-26下午9:40:04
 */
package com.alibaba.webx.study.spring.chapter5.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author zhaoyuanli
 * 2013-6-26下午9:40:04
 */
public class JdbcApp {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "com/alibaba/webx/study/spring/chapter5/dataSource.xml");
        JdbcDAO jdbcDAO = (JdbcDAO) ctx.getBean("jdbcDAO");
        jdbcDAO.save();
    }

}
