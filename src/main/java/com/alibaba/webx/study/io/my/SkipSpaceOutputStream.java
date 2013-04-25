package com.alibaba.webx.study.io.my;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 利用装饰模式，实现一个转换空格为星号的输出字节流
 * 
 */
public class SkipSpaceOutputStream extends FilterOutputStream {

    public SkipSpaceOutputStream(OutputStream out) {
        super(out);
    }

    /**
     * 重写 装饰类的write（）方法，增加转换空格为星号的操作
     * 
     */
    public void write(int b) throws IOException {
        if(b!=' '){
//            out.write(b);
            super.write(b);
        }else{
            super.write('*');
        }
    }
    
    /**
     * 测试
     * 
     */
    public static void main(String[] args) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("hello world!".getBytes());
        SkipSpaceOutputStream sos = new SkipSpaceOutputStream(new DataOutputStream(System.out));
        
        int temp;
        while((temp=in.read())!=-1){
            sos.write(temp);
        }
        
        in.close();
        sos.close();
    }

}
