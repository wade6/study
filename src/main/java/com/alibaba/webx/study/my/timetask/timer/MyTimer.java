/**
 * Project: study
 * File Created at 2013-5-23下午10:26:58
 */
package com.alibaba.webx.study.my.timetask.timer;

import java.util.Timer;

/**
 * 任务调度类
 * 
 * @author zhaoyuanli
 * 2013-5-23下午10:26:58
 */
public class MyTimer {
    
    public static void main(String[] args) {
        Timer timer= new Timer();
        
        // 1秒钟后开始第一次，以后每隔2秒执行一次
        timer.schedule(new MyTask(), 1000, 2000);
        
        System.out.println("task over");
    }

}
