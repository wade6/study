package com.alibaba.webx.study.my.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 压缩和解压缩
 * 
 * 类 ZipStreamTest 的实现描述：TODO 类实现描述
 * @author huamo
 * Apr 23, 201310:31:44 AM
 */
public class ZipStreamTest {

    public static void main(String[] args) throws Exception {
//        zip();
//        unzip();
        unzips();
    }
    
    /**
     *  压缩一个文件
     *  
     */
    private static void zip() throws Exception{
        String src = "/home/huamo/io/writeString.txt";
        String src2 = "/home/huamo/io/writeString.zip";
        File f = FileOperate.createFile(src);
        File zipf = FileOperate.createFile(src2);
        
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipf));
        
        InputStream input = new FileInputStream(f);
        zipOut.putNextEntry(new ZipEntry(f.getName()));
         // 设置注释
        zipOut.setComment("hello");
        
        int temp = 0;
        while((temp = input.read()) != -1){
            zipOut.write(temp);
        }
        
        input.close();
        
        zipOut.close();
        
    }
    
    /**
     * 解压一个文件
     * 
     */
    private static void unzip() throws Exception{
        String src = "/home/huamo/io/unzip.txt";
        String src2 = "/home/huamo/io/writeString.zip";
        
        File outf = FileOperate.createFile(src);
        File zipf = FileOperate.createFile(src2);
        
        ZipFile zipFile = new ZipFile(zipf);
        
        // 设置要被解压的文件
        ZipEntry entry = zipFile.getEntry("writeString.txt");
        
        InputStream input = zipFile.getInputStream(entry);
        
        OutputStream output = new FileOutputStream(outf);
        
        int temp = 0;
        while((temp = input.read()) != -1){
            output.write(temp);
        }
        
        input.close();
        output.close();
    }
    
    /**
     * 解压缩一个压缩文件中包含多个文件的情况
     * 
     */
    private static void unzips() throws Exception{
        
        String src2 = "/home/huamo/io/writeString.zip";
        File zipf = FileOperate.createFile(src2);
        
        // 根据entry从中获取entry的输入流
        ZipFile zipFile = new ZipFile(zipf);
        
        // 从中获取entry
        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(zipf));
        
        ZipEntry entry = null;
        InputStream input = null;
        OutputStream output = null;
        File outFile = null;
        
        while((entry = zipInput.getNextEntry()) != null){
            System.out.println("解压缩" + entry.getName() + "文件");
            outFile = new File("/home/huamo/io" + File.separator + entry.getName());
            
            if(!outFile.getParentFile().exists()){
                outFile.getParentFile().mkdir();
            }
            
            if(!outFile.exists()){
                outFile.createNewFile();
            }
            
            input = zipFile.getInputStream(entry);
            
            output = new FileOutputStream(outFile);
            
            int temp = 0;
            while((temp = input.read()) != -1){
                output.write(temp);
            }
            
            input.close();
            
            output.close();
        }
    }
}
