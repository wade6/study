package com.alibaba.webx.study.app1.module.screen.upload;

import javax.annotation.Resource;

import org.apache.commons.fileupload.FileItem;

import com.alibaba.citrus.service.requestcontext.parser.ParserRequestContext;
import com.alibaba.citrus.turbine.Context;

public class ImageUploadAction {

	@Resource
    private ParserRequestContext parser;// webx获取上传文件的requestContext
	
	public void execute( Context context) throws Exception {
		FileItem file = parser.getParameters().getFileItem("Filedata");
		System.out.println(file.getSize());
	}
}
