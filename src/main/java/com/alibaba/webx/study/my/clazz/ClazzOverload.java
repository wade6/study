package com.alibaba.webx.study.my.clazz;

/**
 * 方法的重载，类型会逐级向上转换
 * 
 * @author huamo
 * Apr 22, 20131:26:24 PM
 */
public class ClazzOverload {
    
//    public static void say(Object arg){
//        System.out.println("say object");
//    }
    
    public static void say(char... arg){
        System.out.println("say char ...");
    }
    
    // 这个参数与char...冲突
//    public static void say(int... arg){
//        System.out.println("say int ");
//    }
    
    public static void main(String[] args) {
        say('a');
    }

}
