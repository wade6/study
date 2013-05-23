/**
 * Project: study
 * File Created at 2013-5-23下午10:43:12
 */
package com.alibaba.webx.study.my.bitoperation;

/**
 * java位运算<p>
 * 位移动运算符  <<:表示左移, 左移一位表示原来的值乘2； >>：表示右移. 右移一位表示除2
 * 
 * 位运算<p>
 * 位运算符包括:　与（&）、非（~）、或（|）、异或（^）
 * 
 * @author zhaoyuanli
 * 2013-5-23下午10:43:12
 */
public class BitOperationDemo {

    public static void main(String[] args) {
        // 位移动运算符
        int number = 8;
        System.out.println(number<<1);// 16
        System.out.println(number>>1);// 4
        
        System.out.println("**********");
        
        
    }
}
