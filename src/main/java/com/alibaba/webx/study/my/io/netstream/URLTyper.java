package com.alibaba.webx.study.my.io.netstream;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTyper {

	public static void main(String[] args) throws IOException {
	    InputStream in = null;
	    try {
	      URL u = new URL("http://pms.cainiao.alibaba.com/ok.htm");
	      in = u.openStream();// 阻塞，等待读取url内容
	      for (int c = in.read(); c != -1; c = in.read( )) {
	        System.out.write(c);
	      }
	    }
	    catch (MalformedURLException ex) {
	      System.err.println(" is not a URL Java understands.");
	    }
	    finally {
	      if (in != null) in.close( );
	    }
	  }
	

}
