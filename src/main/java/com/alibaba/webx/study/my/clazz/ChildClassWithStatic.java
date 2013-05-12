package com.alibaba.webx.study.my.clazz;

/**
 * 静态方法属于所在的类
 * 
 * @author huamo
 * Apr 19, 20134:14:34 PM
 */
public class ChildClassWithStatic extends ParentClazzWithStatic {
    
//    @Override 报错，找不到父类被覆盖的类
    public static void say(){
        System.out.println("ChildClassWithStatic say");
    }
    
    public static void main(String[] args) {
        ChildClassWithStatic.say();
        ParentClazzWithStatic.say();
    }

}
