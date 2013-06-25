/**
 * Project: study
 * File Created at 2013-6-25下午11:16:43
 */
package com.alibaba.webx.study.spring.chapter4.autoaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 
 * @author zhaoyuanli
 * 2013-6-25下午11:16:43
 */
public class PersonAdvice implements MethodInterceptor{

    /**
     * @author zhaoyuanli
     * 2013-6-25下午11:16:54
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("*********before doThing!");
        Object returnValue = invocation.proceed();
        System.out.println("*********after doThing!");
        return returnValue;
    }

}
