/**
 * Project: study
 * File Created at 2013-5-19下午4:08:41
 */
package com.alibaba.webx.study.my.thread.callable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author zhaoyuanli
 * 2013-5-19下午4:08:41
 */
public class TaskWithResult implements Callable<String> {

    /**
     * @author zhaoyuanli
     * 2013-5-19下午4:08:56
     */
    @Override
    public String call() throws Exception {
        // TODO Auto-generated method stub
//        Thread.sleep(1000);
        
        TimeUnit.MILLISECONDS.sleep(1000);
        
        return Thread.currentThread().getName()+" :TaskWithResult";
    }
    
    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        
        for(int i=0;i<5;i++){
            results.add(exe.submit(new TaskWithResult()));
        }
        
        System.out.println("ok");
        
        // fs.get()阻塞，等待线程返回数据
        int i=1;
        for(Future<String> fs : results){
            try {
                if(!fs.isDone()){
                    System.out.println(i+" waiting...");
                    i++;
                }
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        exe.shutdown();
        
        System.out.println("main over!");
    }

}
