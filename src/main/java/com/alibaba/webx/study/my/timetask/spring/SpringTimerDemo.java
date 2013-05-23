/**
 * Project: study
 * File Created at 2013-5-23下午11:48:35
 */
package com.alibaba.webx.study.my.timetask.spring;

import java.util.Timer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.timer.TimerFactoryBean;

/**
 * 有两种流行Spring定时器配置：Java的Timer类和OpenSymphony的Quartz。
 * 
 * @author zhaoyuanli
 * 2013-5-23下午11:48:35
 */
@SuppressWarnings("deprecation")
public class SpringTimerDemo {

    public static void main(String[] args) {
//        MyTask task = new MyTask();
//        ScheduledTimerTask schdule = new ScheduledTimerTask(task,1000,1000,false);
//        ScheduledTimerTask[] array = {schdule};
//        TimerFactoryBean timer = new TimerFactoryBean();
//        timer.setScheduledTimerTasks(array);
//        timer.afterPropertiesSet();
        
        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:spring/spring-timer-bean.xml");
        Timer timer = (Timer) factory.getBean("timer");
        System.out.println("over");
    }
}
