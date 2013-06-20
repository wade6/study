/**
 * Project: study
 * File Created at 2013-6-20下午10:20:38
 */
package com.alibaba.webx.study.spring.chapter1.di;

/**
 * 
 * @author zhaoyuanli
 * 2013-6-20下午10:20:38
 */
public class GreetingServiceImpl implements GreetingService {

    private String greeting;
    
    public GreetingServiceImpl(){
    }
    
    public GreetingServiceImpl(String greeting){
        this.greeting = greeting;
    }
    
    /**
     * @author zhaoyuanli
     * 2013-6-20下午10:20:38
     */
    @Override
    public void sayGreeting() {
        System.out.println(greeting);
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    
}
