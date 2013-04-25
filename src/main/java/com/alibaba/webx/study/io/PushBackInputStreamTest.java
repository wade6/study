package com.alibaba.webx.study.io;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

/**
 * 回退流
 * 
 * @author huamo
 * Apr 23, 20131:10:25 PM
 */
public class PushBackInputStreamTest {

    public static void main(String[] args) throws Exception {
        
        String str = "test 2012 end!";
        
        ByteArrayInputStream bin = new ByteArrayInputStream(str.getBytes());
        
        PushbackInputStream push = new PushbackInputStream(bin);
        
        int temp = 0;
        
        while((temp = push.read()) != -1){
            
            if(temp == 'n'){
                push.unread(temp);
                temp = push.read();
                System.out.print("(回退" + (char) temp + ") ");
            }else{
                System.out.print((char) temp);
            }
        }
    }
}
