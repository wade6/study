package com.alibaba.webx.study.my.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.io.Writer;

/**
 * 关于字节流和字符流的区别
 * 实际上字节流在操作的时候本身是不会用到缓冲区的，是文件本身的直接操作的，
 * 但是字符流在操作的 时候下后是会用到缓冲区的，是通过缓冲区来操作文件的。
 * 可以试着将字节流和字符流的程序的最后一行关闭文件的代码注释掉，然后运行程序看看。
 * 会发现使用字节流的话，文件中已经存在内容，但是使用字符流的时候，文件中还是没有内容的，这个时候就要刷新缓冲区。
 */
public class IOOperate {
	
	public static void main(String[] args) throws Exception {
//		random();
//		
//		writeString();
		
//		writeByByte();
		
//		readFile();
		
//		CharStream();
		
//		byteCharConvert();
		
//		memStream();
		
//		pipedStream();
		
//		redirection();
	    
	    BufferedReaderTest();
	    
		
		
	}
	/**
	 *  RandomAccessFile
	 */
	private static void random() throws IOException{
		String src = "d:\\io\\randomFile.txt";
		File f = FileOperate.createFile(src);
		
		RandomAccessFile demo=new RandomAccessFile(f,"rw");
		demo.writeBoolean(true);
		demo.writeBytes("hello");
		demo.close();
	}
	
	/**
	 *  字节流：整个字符串写入 FileOutputStream
	 */
	private static void writeString() throws Exception{
		String src = "d:\\io\\writeString.txt";
		File f = FileOperate.createFile(src);
		
		FileOutputStream out = new FileOutputStream(f);
		
		String str = "hello!你好！整个字符串写入文件";
		
		byte[] b =str.getBytes();
		
		// 调用的是 native void writeBytes(byte b[], int off, int len)
		out.write(b);
		
		out.close();
	}
	
	/**
	 *  字节流：单个字节写入 FileOutputStream
	 */
	private static void writeByByte() throws Exception{
		String src = "d:\\io\\writeString.txt";
		File f = FileOperate.createFile(src);
		
		FileOutputStream out = new FileOutputStream(f);
		
		String str = "hello!你好！单个字节写入文件";
		
		byte[] b =str.getBytes();
		
		for(byte bi : b){
			// 调用的是 native void write(int b)
			out.write(bi);
		}
		
		out.close();
	}
	
	/**
	 *   字节流：读取文件
	 */
	private static void readFile() throws Exception{
		String src = "d:\\io\\writeString.txt";
		File f = FileOperate.createFile(src);
		
		FileInputStream in = new FileInputStream(f);
		
		byte[] b = new byte[(int)f.length()];
		
		in.read(b);
		
		in.close();
		
		System.out.println(new String(b,"GBK"));
		
	}
	
	/**
	 *  字符流 : 读写文件
	 */
	private static void CharStream() throws Exception{
		String src = "d:\\io\\writeString.txt";
		File f = FileOperate.createFile(src);
		
		// 写字符
		Writer w = new FileWriter(f);
		String str = "hello! 字符流";
		
		w.write(str);
		
		w.close();
		
		// 读文件
		Reader r = new FileReader(f);
		
		char[] ch = new char[100];
		
		int temp=0;
		int count=0;
		
		while((temp=r.read())!=-1){
			ch[count++] = (char) temp;
		}
		r.close();
		
		System.out.println(new String(ch,0,count));
	}
	
	/**
	 * 字节与字符转换流
	 * 
	 * OutputStreramWriter将输出的字符流转化为字节流
	 * InputStreamReader将输入的字节流转换为字符流
	 * @throws Exception 
	 */
	private static void byteCharConvert() throws Exception{
		String src = "d:\\io\\writeString.txt";
		File f = FileOperate.createFile(src);
		
		// 将 字符输出流  转换成 字节输出流,输出字节
		Writer w = new OutputStreamWriter(new FileOutputStream(f));
		
		w.write("hello!OutputStreamWriter");
		
		w.close();
		
		// 将 输入的字节流 转换为 字符流，读取字符
		Reader r = new InputStreamReader(new FileInputStream(f));
		
		char[] b = new char[100];
		
		int len = r.read(b);
		
		System.out.println(new String(b,0,len));
		
		
	}
	
	/**
	 * 内存操作流
	 * 
	 * ByteArrayInputStream 主要将内容写入内存
	 * ByteArrayOutputStream  主要将内容从内存输出
	 * @throws Exception 
	 */
	private static void memStream() throws Exception{
		String str = "hello!memStream!";
		ByteArrayInputStream bi= new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		int temp;
		while((temp=bi.read())!=-1){
			char ch = (char)temp;
			bo.write(Character.toUpperCase(ch));
		}
		String outStr = bo.toString();
		
		bi.close();
		bo.close();
		
		System.out.println(outStr);
	}
	
	/**
	 * 管道流
	 * 
	 * 管道流主要可以进行两个线程之间的通信。
	 * PipedOutputStream 管道输出流
	 * PipedInputStream 管道输入流
	 * @throws Exception 
	 */
	private static void pipedStream() throws Exception{
		
	    // 发送消息的线程
		class Send implements Runnable{
			
			private PipedOutputStream out = null;
			
			public Send(){
				out = new PipedOutputStream();
			}
			
			public PipedOutputStream getOut(){
		        return this.out;
		    }

			@Override
			public void run() {
				String message = "hello!你好piped!";
				try {
					out.write(message.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		// 接受消息的线程
		class Recive implements Runnable{
			
			private PipedInputStream in = null;
			
			public Recive(){
				in = new PipedInputStream();
			}
			
			public PipedInputStream getIn(){
		        return this.in;
		    }
			
			@Override
			public void run() {
				byte[] b = new byte[100];
				int len=0;
				try {
					len = in.read(b);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("recive:"+new String(b,0,len));
			}
			
		}
		
		// 初始化两个线程
		Send s = new Send();
		Recive r = new Recive();
		
		// 管道连接
		s.getOut().connect(r.getIn());
		
		// 运行线程
		new Thread(s).start();
		new Thread(r).start();
		
	}
	
	/**
	 * 输入输出重定向
	 * @throws Exception 
	 */
	private static void redirection() throws Exception{
	    // 输出重定向
	    System.out.println("显示在屏幕");
	    
	    String src = "/home/huamo/io/writeString.txt";
        File f = FileOperate.createFile(src);
        
        System.setOut(new PrintStream(new FileOutputStream(f)));
        
        System.out.println("通过System.out.println输入到文件里了");
	}
	
	/**
	 * BufferedReader
	 * @throws IOException 
	 */
	
	private static void BufferedReaderTest() throws IOException{
	    InputStreamReader in = new InputStreamReader(System.in);
	    System.out.println("请输入：");
	    char[] ch = new char[100];
	    // 等待输入
	    in.read(ch);
	    
	    System.out.println("读入的内容为："+new String(ch));
	    
	    BufferedReader br = new BufferedReader(in);
	    System.out.println("请输入：");
	 // 等待输入
	    String input = br.readLine();
	    System.out.println("读入的内容2为："+input);
	    
	    br.close();
	}
	

}
