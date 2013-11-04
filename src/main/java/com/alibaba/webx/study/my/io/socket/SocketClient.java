package com.alibaba.webx.study.my.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("127.0.0.1",8010);
		
		BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter os=new PrintWriter(socket.getOutputStream());
		
		BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String readline=sin.readLine();
		
		while(!readline.equals(".")){
			os.println(readline);
			os.flush();
			
			System.out.println("Server say:"+is.readLine());
			readline=sin.readLine();
		}
		
		os.close(); //关闭Socket输出流
		is.close(); //关闭Socket输入流
		socket.close(); //关闭Socket
	}

}
