package com.alibaba.webx.study.my.io.socket.httpserver.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 客户端请求处理线程
 * 
 * @author zhaoyuan.lizy
 *
 */
public class RequestProcessThread implements Runnable {
	
	private InputStream in;  
    private PrintStream out; 
    
//    private byte[] _1M;// 1M内存空间
	
	public RequestProcessThread(Socket socket){
		try {
			in = socket.getInputStream(); // 获取输入流
			out = new PrintStream(socket.getOutputStream());  // 获取输出流
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
//		_1M = new byte[1024];
//		try {
//			System.in.read();// 阻塞线程执行
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
		this.paserWithHttp(in);
	}
	
	/**
	 * 按照http协议解析客户端请求
	 * @param in
	 * @return
	 */
	private void paserWithHttp(InputStream in){
		BufferedReader br = new BufferedReader(new InputStreamReader(in));  
        try {
			String httpMessage = br.readLine();// 此处阻塞，readLine会去找换行符判断是否结束写入
			String[] httpContent = httpMessage.split(" ");//协议状态号，名称，版本号  
			
			//如果客戶端输入协议错误则返回错误页面  
            if(httpContent.length != 3) {  
                this.sendMessage(400, "Client http error！");  
                return;  
            }  
            
            //输出协议信息  
            System.out.println("code: "+httpContent[0]+" ,path: "+httpContent[1]+  
                    " httpVersion: "+httpContent[2]);  
            String respoonseInfo = "request:"+httpContent[1];
            // 返回客户端
            this.sendMessage(200, respoonseInfo);  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}

	// 返回页面输出方法  
    public void sendMessage(int code, String content) {  
    	
    	try {  
	        out.println("HTTP/1.0 "+code+" "+content);  
	        out.println("content-type: text/html");  
	        out.println("Server:my web server");
	        out.println("author:hm"); // 自定义头信息
	        
	        out.println();  // 头跟消息体的空行
	        
	        out.println("<html>");  
	          
	        out.println("<title>From my web server");  
	        out.println("</title>");  
	        out.println("<body>");  
	        out.println("<h1>"+content+"</h1>");         
	          
	        out.println("</body>");  
	        out.println("</html>");  
	          
	        out.flush();  
	        out.close();  
	        
            in.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}
