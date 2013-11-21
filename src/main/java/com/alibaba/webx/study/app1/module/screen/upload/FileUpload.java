package com.alibaba.webx.study.app1.module.screen.upload;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.citrus.service.requestcontext.parser.ParserRequestContext;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;

public class FileUpload {
	
	@Resource
	private HttpServletRequest request;
	
	@Resource
    private ParserRequestContext parser;// webx获取上传文件的requestContext
	
	public void execute(@Param("note") String note, Context context) throws Exception {
		
		if(request.getMethod().equals("GET")){
			return;
		}
		
		String result = null;
		result = "param:"+note;
		
//		FileItem item = parser.getParameters().getFileItem("upfile");// webx获取file
//		result = result+"webxfile:"+item.getName();
		
		commonFileUpload();
		
		
		context.put("message", result);
	}

	/**
	 * 使用apache的common-fileupload，因为webx.xml中的<request-contexts:parser />已经将文件读取eof了，所以这里拿到的是null，但是设置autoUpload="false" 即可
	 * @param item
	 * @throws FileUploadException
	 */
	private void commonFileUpload() throws FileUploadException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);//检查输入请求是否为multipart表单数据。
		if (isMultipart == true) {
			FileItemFactory factory = new DiskFileItemFactory();//为该请求创建一个DiskFileItemFactory对象，通过它来解析请求。执行解析后，所有的表单项目都保存在一个List中。
			ServletFileUpload upload = new ServletFileUpload(factory);
		    List<FileItem> items = upload.parseRequest(request);
		    
		    Iterator<FileItem> itr = items.iterator();
		    while (itr.hasNext()) {
		    	FileItem fitem = (FileItem) itr.next();
		    	if (fitem.isFormField()) {//如果是普通表单项目，显示表单内容。
	    	       String fieldName = fitem.getFieldName();
	    	       if (fieldName.equals("note")) //对应.html中type="text" name="name"
	    	           System.out.print("the field name is" + fitem.getString());//显示表单内容。
	    	       System.out.print("<br>");
		    	} else {//如果是上传文件，显示文件名。
	        	   System.out.print("the upload file name is" + fitem.getName());
	        	   System.out.print("<br>");
	            }
		    }
		}
	}

}
