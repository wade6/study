/**
 * Project: study
 * File Created at 2013-5-18上午11:42:40
 */
package com.alibaba.webx.study.my.java;

/**
 * @author zhaoyuanli 2013-5-18上午11:42:40
 */
public class Test {

    public static void main(String[] args) {
        //        int a = 0;
        //        int b[] = new int[5];
        //        int c = 3;
        //        b[a] = a = c;
        //        System.out.println(a);

        String a = "JAVA";
        String b = "JAVA";
        String c = new String("JAVA");
        String d = "JA";
        String e = "VA";
        String f = "JA" + "VA";
        String g = d + e;
        String h = c;
       
        System.out.println(a==b); //true
        System.out.println(a==c); 
        System.out.println(a==f); //true
        System.out.println(a==g);
        System.out.println(c==f);
        System.out.println(c==g);
        System.out.println(c==h); //true
    }

}

/**
 * http://wenku.baidu.com/view/ac69f04733687e21af45a923.html java笔试题
 * http://blog.renren.com/blog/224547370/393330369 java基础
 */
