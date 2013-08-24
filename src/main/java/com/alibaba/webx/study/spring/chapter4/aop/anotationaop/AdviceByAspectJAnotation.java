/**
 * Project: study
 * File Created at 2013-6-25下午11:24:41
 */
package com.alibaba.webx.study.spring.chapter4.aop.anotationaop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 使用注解在该通知的实现上定义切面 
 * 
 * @author zhaoyuanli
 * 2013-6-25下午11:24:41
 */
@Aspect  // 声明切面
public class AdviceByAspectJAnotation {
    
    public AdviceByAspectJAnotation(){
        
    }
    
    @Pointcut("execution(* *.doThing(..))") // 定义切点
    public void doThings(){
        
    }
    
    @Before("doThings()") // 定义前置通知
    public void beforeDoThing(){
        System.out.println("***before doThing by AspectJ Anotation");
    }
    
    @AfterReturning("doThings()") // 定义后置通知
    public void afterDoThing(){
        System.out.println("***after doThing by AspectJ Anotation");
    }


}
