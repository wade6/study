package com.alibaba.webx.study.my.io.socket.httpserver.bio;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * web 服务器启动类
 * 
 * BIO模式多线程socket实现简单web server;进一步改进，使用线程池
 * 
 * @author zhaoyuan.lizy
 *
 */
public class WebServer {
	
	private static int index = 0;

	public static void main(String[] args) {
		
		int port = 8080; // 定义服务端口号
		new WebServer().start(port); // 启动web服务器
		
	}
	
	public void start(int port){
		
		try {
			
			System.out.println("my web server start!");
			ServerSocket serverSocket = new ServerSocket(port);
			while(true){
				Socket clientConn = serverSocket.accept(); //监听客户端的请求
				new Thread(new RequestProcessThread(clientConn),"requestThread"+index).start();//启动线程进行处理
				index++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
