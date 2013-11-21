package com.alibaba.webx.study.app1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1013180556678054991L;
	
	public void service(ServletRequest req, ServletResponse res)
	        throws ServletException, IOException
	    {
	        HttpServletRequest  request;
	        HttpServletResponse response;
	        
	        if (!(req instanceof HttpServletRequest &&
	                res instanceof HttpServletResponse)) {
	            throw new ServletException("non-HTTP request or response");
	        }

	        request = (HttpServletRequest) req;
	        response = (HttpServletResponse) res;

	        service(request, response);
	    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
    {
//		resp.flushBuffer();
        String protocol = req.getProtocol();
        String msg =  "http.method_get_not_supported" ;
        if (protocol.endsWith("1.1")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, msg);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, msg);
        }
    }
}
