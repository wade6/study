package com.alibaba.webx.study.my.io;

import java.util.Scanner;

public class ScannerTest {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        // 读取一个整数
        int i = scn.nextInt();
        System.out.println("整数为："+i);
        
        // 读取一个字符串
        float f = scn.nextFloat();
        System.out.println("float:"+f);
    }

}
