package com.alibaba.webx.study.my.io.socket.singlethread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单线程的socket server，纯文本传输，请求和响应交替进行
 * 
 * @author zhaoyuan.lizy
 *
 */
public class SocketServer {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(8010);//创建一个ServerSocket在端口8010监听客户请求
		
		System.out.println("start");
		
		Socket conn = server.accept();//使用accept()阻塞等待客户请求
		
		String line;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		line = br.readLine();
		System.out.println("client say:"+line);//打印从客户端读入的字符串
		
		BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
		line=sin.readLine();// 阻塞！从标准输入读入一字符串
		
		PrintWriter os = new PrintWriter(conn.getOutputStream());// 构造输出流，向客户端输出
		
		while(!line.endsWith(".")){//服务端需要回应客户端每个请求
			os.println(line);
			os.flush();// 客户端马上收到字符串
			line = br.readLine(); 
			System.out.println("client say:"+line);
			line = sin.readLine();
		}
		
		os.close();
		br.close();
		conn.close();
		server.close();
	}

}
