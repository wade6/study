package com.alibaba.webx.study.my.io.socket.singlethread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 模拟客户端浏览器的socket请求，纯文本传输，请求和响应交替进行
 * 
 * @author zhaoyuan.lizy
 *
 */
public class SocketClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("127.0.0.1",8010);// 建立socket链接
		
		PrintWriter os=new PrintWriter(socket.getOutputStream());// 获取socket输出流
		BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));// 获取socket输入流
		
		System.out.println("input:");
		BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));// 创建标准输入
		String readline=sin.readLine();// 阻塞等待输入
		
		while(!readline.equals(".")){
			os.println(readline);// 写入socket输出流，等待发给服务端
			os.flush(); // 发送至服务端
			System.out.println("Server say:"+is.readLine());// 阻塞！等待服务端应答
			readline=sin.readLine();
		}
		
		os.close(); //关闭Socket输出流
		is.close(); //关闭Socket输入流
		socket.close(); //关闭Socket
	}

}
