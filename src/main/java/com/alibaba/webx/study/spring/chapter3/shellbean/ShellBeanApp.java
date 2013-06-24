/**
 * Project: study
 * File Created at 2013-6-24下午10:12:45
 */
package com.alibaba.webx.study.spring.chapter3.shellbean;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 脚本化的bean,不需要编译和重新部署
 * 
 * @author zhaoyuanli
 * 2013-6-24下午10:12:45
 */
public class ShellBeanApp {
    
    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext(
                "com/alibaba/webx/study/spring/chapter3/beanPostProcessor.xml");
        Person3 p = (Person3)cxt.getBean("person3");
        Scanner in=new Scanner(System.in);
        String readLine = null;
        do{
            readLine = in.nextLine();
            p.drinkThing();
        }while(!readLine.equals("a"));
        
    }
}
