/**
 * Project: study
 * File Created at 2013-6-25下午11:24:41
 */
package com.alibaba.webx.study.spring.chapter4.aop;

import org.aspectj.lang.ProceedingJoinPoint;


/**
 * 
 * @author zhaoyuanli
 * 2013-6-25下午11:24:41
 */
public class PojoAdvice {
    
    
    public void beforeDoThing(){
        System.out.println("***before doThing");
    }
    
    public void afterDoThing(){
        System.out.println("***after doThing");
    }
    
    public void around(ProceedingJoinPoint joinpoint){
    	
    	
    	try {
    		System.out.println("***before doThing around");
    		
			joinpoint.proceed();
			
			System.out.println("***after doThing around");
		} catch (Throwable e) {
			System.out.println("***after throw exception around");
		}
    	
    	
    }
    
    // 带有传参
    public void around2(ProceedingJoinPoint joinpoint,String things){
    	
    	
    	try {
    		System.out.println("***before doThing around:"+things);
    		
			joinpoint.proceed();
			
			System.out.println("***after doThing around:"+things);
		} catch (Throwable e) {
			System.out.println("***after throw exception around");
		}
    	
    	
    }


}
