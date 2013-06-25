/**
 * Project: study
 * File Created at 2013-6-25下午11:24:41
 */
package com.alibaba.webx.study.spring.chapter4.autoaop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * @author zhaoyuanli
 * 2013-6-25下午11:24:41
 */
@Aspect
public class PersonAspectJ {
    
    public PersonAspectJ(){
        
    }
    
    @Pointcut("execution(* *.doThing(..))")
    public void doThings(){
        
    }
    
    @Before("doThings()")
    public void beforeDoThing(){
        System.out.println("***beforeDoThing");
    }
    
    @AfterReturning("doThings()")
    public void afterDoThing(){
        System.out.println("***afterDoThing");
    }


}
