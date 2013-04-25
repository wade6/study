package com.alibaba.webx.study.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;

/**
 * 合并流
 * @author huamo
 * Apr 23, 20139:40:35 AM
 */
public class SequenceInputStreamTest {

    public static void main(String[] args) throws Exception {
        // 两个输入流
        InputStream in1 = new ByteArrayInputStream("hello".getBytes());
        InputStream in2 = new ByteArrayInputStream("你好".getBytes());
        
        // 合并到输入流
        SequenceInputStream ss = new SequenceInputStream(in1,in2);
        
        String src = "/home/huamo/io/writeString.txt";
        File f = FileOperate.createFile(src);
        // 定义输出流到文件
        FileOutputStream out = new FileOutputStream(f);
        
        int temp;
        
        while((temp=ss.read())!=-1){
            out.write(temp);
        }
        
        out.close();
        ss.close();
    }
}
