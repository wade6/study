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
		
		Socket socket = new Socket("127.0.0.1",8010);
		
		BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter os=new PrintWriter(socket.getOutputStream());
		
		BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		System.out.println("input:");
		String readline=sin.readLine();
		
		while(!readline.equals(".")){
			os.println(readline);
			os.flush(); // 发送至服务端
			System.out.println("Server say:"+is.readLine());// 阻塞！等待服务端应答
			readline=sin.readLine();
		}
		
		os.close(); //关闭Socket输出流
		is.close(); //关闭Socket输入流
		socket.close(); //关闭Socket
	}

}
