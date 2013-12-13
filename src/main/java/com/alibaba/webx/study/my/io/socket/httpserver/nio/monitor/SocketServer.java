package com.alibaba.webx.study.my.io.socket.httpserver.nio.monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.StringUtils;

/**
 * 模拟NIO中Selector（selector中的就绪事件是操作系统通知）
 * 问题：线程一直在运行；占用cpu
 * 
 * @author zhaoyuan.lizy
 *
 */
public class SocketServer {
	
	static List<Socket> socketList = new ArrayList<Socket>();
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ServerSocket server = new ServerSocket(8010);//创建一个ServerSocket在端口8010监听客户请求
		
		Thread t1  = new Thread(new MySelector(),"t1");// 创建一个守护线程，循环便利所有的socket，监听请求是否就绪
		
		t1.start();
		
		System.out.println("start");
		
		while(true){
			
			Socket conn = server.accept();//使用accept()阻塞等待客户请求
			
			System.out.println("client is coming"+new Date().toGMTString());
			
			socketList.add(conn);// 将新的请求链接添加到队列中
		}
		
	}
	
	static class MySelector implements Runnable{

		@Override
		public void run() {
			
			while(true){// 循环检测socket是否可读
				
				for(Socket conn : socketList){
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						
						if(br.ready()){
							// 分配线程处理该请求，实现一个请求一个线程
							System.out.println("thread process socket"); 
							String line = br.readLine();
							while(!StringUtils.isNullOrEmpty(line)){
								System.out.println("client say:"+line);//打印从客户端读入的字符串
								line = br.readLine();
							}
							
							br.close();
							conn.close();
							socketList.remove(conn);
						} 
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
			
			
		}
		
	}
	
}
