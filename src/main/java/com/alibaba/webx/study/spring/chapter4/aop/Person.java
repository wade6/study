/**
 * Project: study
 * File Created at 2013-6-25下午11:11:52
 */
package com.alibaba.webx.study.spring.chapter4.aop;

/**
 * 
 * @author zhaoyuanli
 * 2013-6-25下午11:11:52
 */
public class Person {

    public void doThing(){
        System.out.println("person doThing");
    }
    
    public void doThing(String things){
        System.out.println("person do "+things);
    }
}
