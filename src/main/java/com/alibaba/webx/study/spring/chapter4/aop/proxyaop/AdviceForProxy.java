/**
 * Project: study
 * File Created at 2013-6-25下午11:16:43
 */
package com.alibaba.webx.study.spring.chapter4.aop.proxyaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 需要自定义通知的实现
 * 
 * @author zhaoyuanli
 * 2013-6-25下午11:16:43
 */
public class AdviceForProxy implements MethodInterceptor{

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
