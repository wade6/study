/**
 * Project: study
 * File Created at 2013-5-19下午6:15:43
 */
package com.alibaba.webx.study.my.thread.volatiles;

import java.util.concurrent.TimeUnit;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * 
 * @author zhaoyuanli
 * 2013-5-19下午6:15:43
 */
public class VolatileDemo {
    
    private  static boolean a =false;

    public static void main(String[] args) throws InterruptedException {
        
        try {
            Context ctx=new InitialContext();
        } catch (NamingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        Thread th = new Thread(new Runnable(){

            @Override
            public void run() {
                int i =0;
                while(!a){
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    i++;
                    System.out.println(i);
                }
                System.out.println(a);
            }
            
        });
//        th.setDaemon(true);
        
        th.start();
        
        TimeUnit.SECONDS.sleep(1);
        a = true;
        System.out.println("main over");
    }

}
