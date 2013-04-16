package com.alibaba.webx.lzy.app1.study.annotation.test;

import java.lang.reflect.Method;

import com.alibaba.webx.lzy.app1.study.annotation.Copyright;
import com.alibaba.webx.lzy.app1.study.annotation.Mytest;
import com.alibaba.webx.lzy.app1.study.annotation.Preliminary;
import com.alibaba.webx.lzy.app1.study.annotation.RequestForEnhancement;

@Copyright("alibaba")
public class AnTest {

    @RequestForEnhancement(id = 2868724, 
            synopsis = "Enable time-travel", 
            engineer = "Mr. Peabody", 
            date = "4/1/3007"
    )
    public static void print1() {
        System.out.println(1);
    }
    
    @Preliminary
    @Mytest
    public static void print2(){
        System.out.println(2);
    }
    
    @Mytest
    public void print3(){
        System.out.println(3);
    }
    
    /**
     * 这个方法遍历此类的所有方法，尝试调用其中被上面的测试annotation类型标注过的方法
     * @author zhaoyuan.lizy
     * 2012-10-19下午4:44:19
     * @param args
     * @throws SecurityException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws SecurityException, ClassNotFoundException {
        int passed = 0, failed = 0;
        for (Method m : Class.forName("com.alibaba.webx.lzy.app1.study.annotation.test.AnTest").getMethods()) {
            if (m.isAnnotationPresent(Mytest.class)) {
                try {
                   m.invoke(null);
                   passed++;
                } catch (Throwable ex) {
                   System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                   failed++;
                }
             }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
    
}
