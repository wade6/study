package com.alibaba.webx.study.my.io.socket.httpserver.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class NioClient {
	
	public static void main(String[] args) throws IOException {
		String host = "127.0.0.1";
		InetSocketAddress socketAddress = new InetSocketAddress(host, 8081);
			
		SocketChannel channel = SocketChannel.open();
		channel.connect(socketAddress);
		channel.configureBlocking(false); // 开启非阻塞，true为阻塞模式，阻塞读和写可以被其它线程中断
	}

}
