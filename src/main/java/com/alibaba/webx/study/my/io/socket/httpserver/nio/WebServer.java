package com.alibaba.webx.study.my.io.socket.httpserver.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * web 服务器启动类
 * 
 * NIO模式多线程socket实现简单web server;进一步改进，使用线程池
 * 
 * @author zhaoyuan.lizy
 *
 */
public class WebServer {
	
	private Selector selector;

	public static void main(String[] args) {
		
		int port = 8080; // 定义服务端口号
		new WebServer().start(port); // 启动web服务器
		
	}
	
	public void start(int port){
		
		try {
			
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false); // 非阻塞模式
			InetSocketAddress isa = new InetSocketAddress(port );
			serverChannel.socket().bind(isa); // 绑定到本地接口
			
			selector = Selector.open(); // 创建一个selector
			
			serverChannel.register( selector,SelectionKey.OP_ACCEPT);// 注册serverchannel
			
			SelectionKey key = null;
			while(true){
				
				System.out.println("my web server start!");
				selector.select();
				
				Iterator it = selector.selectedKeys().iterator();
		         while (it.hasNext()) {
		            key = (SelectionKey) it.next();
		            handleKey(key);
		            it.remove();
		         }
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void handleKey(SelectionKey key) throws IOException{
		SocketChannel socket;
		if (key.isAcceptable()) {
		    System.out.println("Acceptable Key");
		    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
		    socket = (SocketChannel) ssc.accept();
		    socket.register(selector,SelectionKey.OP_READ);
		}
		if (key.isReadable()) {
		    System.out.println("Readable Key");
		     
				    
		}
		if (key.isWritable()) {
		    System.out.println("Writable Key");
		 }
	}
}
