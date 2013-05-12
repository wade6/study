package com.alibaba.webx.study.my.clazz.innerclazz;

/**
 * 子类继承的父类和实现的接口中存在同名的方法test，如果子类不实现，子类方法test继承父类的test方法；
 * 如果实现test方法，则覆盖父类的test方法
 * 
 * @author huamo
 * Apr 22, 20134:51:21 PM
 */
public class ChildClazz extends ParentClazz implements TestInterface {
    
    @Override
    public void test(){
        super.test();
        System.out.println("childClazz test!");
    }

    public static void main(String[] args) {
        ChildClazz object = new ChildClazz();
        object.test();
    }
}
