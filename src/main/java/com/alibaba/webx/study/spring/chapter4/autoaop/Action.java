/**
 * Project: study
 * File Created at 2013-6-25下午11:24:41
 */
package com.alibaba.webx.study.spring.chapter4.autoaop;


/**
 * 
 * @author zhaoyuanli
 * 2013-6-25下午11:24:41
 */
public class Action {
    
    public Action(){
        
    }
    
    public void beforeDoThing(){
        System.out.println("***beforeDoThing");
    }
    
    public void afterDoThing(){
        System.out.println("***afterDoThing");
    }


}
