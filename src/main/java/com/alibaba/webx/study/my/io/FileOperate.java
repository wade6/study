package com.alibaba.webx.study.my.io;

import java.io.File;
import java.io.IOException;

/**
 * 文件操作
 * @author zhaoyuanli
 *
 */
public class FileOperate {
	
	public static void main(String[] args) {
		String src = "d:\\newFile.txt";// c盘拒绝访问
		
		// 使用File常量，易实现跨平台
		src = "d:"+File.separator+"newFile2.txt";
		
		createFile(src);
		
		deleteFile(src);
		
		createFolder();
		
		listFiles();
	}

	// 创建文件
	public static File createFile(String src){
		File file = new File(src);
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println(e);
		}
		return file;
	}
	
	// 删除文件
	private static void deleteFile(String src){
		File file = new File(src);
		if(file.exists()){
			file.delete();
		}else{
			System.out.println("文件不存在！");
		}
	}
	
	// 创建文件夹
	private static void createFolder(){
		String src = "d:"+File.separator+"testFoler"+File.separator+"test";
		File file = new File(src);
		file.mkdirs(); // file.mkdir()创建单级文件夹
	}
	
	// 列出文件夹的内容
	private static void listFiles(){
		String src = "d:"+File.separator;
		File file = new File(src);
		String[] list = file.list();
		for(String str : list){
			System.out.println(str);
		}
		System.out.println(list.length);
		 // listFiles输出的是完整路径
		File[] listfile = file.listFiles();
		for(File str : listfile){
			System.out.println(str);
		}
		System.out.println(listfile.length);
	}
}
