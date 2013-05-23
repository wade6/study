package com.alibaba.webx.study.my.timetask.quartz.job;

import java.util.concurrent.TimeUnit;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //获取jobDetail
        JobDetail jobDetail = context.getJobDetail();

        // 获取jobName
        String jobName = jobDetail.getName();

        //获取JobDataMap
        JobDataMap dataMap = jobDetail.getJobDataMap();
        
        //JobDataMap中获取用户传入的参数
        int index = dataMap.getInt("index");
        
        //具体JOB要做的事
        for(int i =0;i<index;i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("simple job name:"+jobName+" ;turn "+i);
        }

    }

}
