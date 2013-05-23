package com.alibaba.webx.study.my.timetask.quartz;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

import com.alibaba.webx.study.my.timetask.quartz.job.SimpleJob;

public class QuartzTest {

    public static void main(String[] args) {

        try {
            // 1、创建一个任务调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            //2、创建一个作业
            JobDetail jobDetail = new JobDetail("simpleJob", Scheduler.DEFAULT_GROUP,
                    SimpleJob.class);

            // 2.1、JobDataMap里面加入需要的参数
            jobDetail.getJobDataMap().put("index", 5);

            //3、创建触发器，每8秒触发一次
            Trigger trigger = TriggerUtils.makeSecondlyTrigger(8);
            trigger.setName("simpleTrigger");
            //3.1、开始触发时间
            trigger.setStartTime(new Date());

            // 4、把作业和触发器
            scheduler.scheduleJob(jobDetail, trigger);

            // 5、启动调度器
            scheduler.start();

            // 6、关闭调度器
//            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
