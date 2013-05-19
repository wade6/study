/**
 * Project: study
 * File Created at 2013-5-19下午3:56:20
 */
package com.alibaba.webx.study.my.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.webx.study.my.thread.Fibonacci;

/**
 * 
 * @author zhaoyuanli
 * 2013-5-19下午3:56:20
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        
        for(int i=0;i<5;i++){
            executor.execute(new Fibonacci(5));
        }
        executor.shutdown();
        System.out.println("main over!");
    }
}
