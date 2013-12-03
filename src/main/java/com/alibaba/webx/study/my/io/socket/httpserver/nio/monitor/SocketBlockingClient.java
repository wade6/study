package com.alibaba.webx.study.my.io.socket.httpserver.nio.monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 模拟客户端浏览器的socket请求，使用PrintWriter，控制flush()的调用实现服务端的阻塞
 * 
 * @author zhaoyuan.lizy
 *
 */
public class SocketBlockingClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("127.0.0.1",8010);
		
		PrintWriter os=new PrintWriter(socket.getOutputStream());// 获取socket输出
		
		System.out.println("input:");
		BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));// 创建标准输入
		String readline=sin.readLine();// 阻塞等待输入
		
		while(!readline.equals(".")){
			
			os.println(readline);// 写入socket输出流，等待发给服务端
			if(readline.equals("flush")){
				os.flush(); // 发送至服务端
			}
			readline=sin.readLine();
		}
		
		os.close(); //关闭Socket输出流
		socket.close(); //关闭Socket
	}

}
