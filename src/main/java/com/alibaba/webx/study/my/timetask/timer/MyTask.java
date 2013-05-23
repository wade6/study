/**
 * Project: study
 * File Created at 2013-5-23下午10:24:54
 */
package com.alibaba.webx.study.my.timetask.timer;

import java.util.TimerTask;

/**
 * 任务类
 * 
 * @author zhaoyuanli
 * 2013-5-23下午10:24:54
 */
public class MyTask extends TimerTask{

    /**
     * @author zhaoyuanli
     * 2013-5-23下午10:25:24
     */
    @Override
    public void run() {
        System.out.println("execute my task!");
    }

}
