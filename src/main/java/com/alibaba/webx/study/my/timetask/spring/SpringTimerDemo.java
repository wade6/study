/**
 * Project: study
 * File Created at 2013-5-23下午11:48:35
 */
package com.alibaba.webx.study.my.timetask.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 有两种流行Spring定时器配置：Java的Timer类和OpenSymphony的Quartz。<p>
 * 
 * Java的Timer类<p>
 * 
 * @author zhaoyuanli
 * 2013-5-23下午11:48:35
 */
public class SpringTimerDemo {

    public static void main(String[] args) {
//        MyTask task = new MyTask();
//        ScheduledTimerTask schdule = new ScheduledTimerTask(task,1000,1000,false);
//        ScheduledTimerTask[] array = {schdule};
//        TimerFactoryBean timer = new TimerFactoryBean();
//        timer.setScheduledTimerTasks(array);
//        timer.afterPropertiesSet();
        
        ApplicationContext factory = new ClassPathXmlApplicationContext("com/alibaba/webx/study/my/timetask/spring/spring-timer-bean.xml");
        System.out.println("****SpringTimerDemo !");
    }
}
