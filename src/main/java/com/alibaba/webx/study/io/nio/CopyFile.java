package com.alibaba.webx.study.io.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {

	private static final String infile = "d:\\io\\infile.txt";

	private static final String outfile = "d:\\io\\outfile.txt";

	public static void main(String[] args) throws Exception {

		// copyFileDefault(infile, outfile);
		
		copyFileWithBuffer(infile, outfile);

//		copyFileWithNIO(infile, outfile);

	}

	/**
	 * 利用标准java io 实现文件的复制
	 * 
	 * @param src
	 * @param dest
	 * @throws Exception
	 */
	private static void copyFileDefault(String src, String dest)
			throws Exception {
		// 创建读取文件输入流
		FileInputStream in = new FileInputStream(src);
		// 检查输出文件
		File file = new File(dest);
		if (!file.exists()) {
			file.createNewFile();
		}
		// 创建写入文件输出流
		FileOutputStream out = new FileOutputStream(dest);

		int temp;

		// 逐个字节进行传输
		while ((temp = in.read()) != -1) {
			out.write(temp);
		}

		// 关闭输入输出流
		in.close();
		out.close();

		System.out.println("copy complated!");

	}

	// CPU处理速度远大于IO速度，程序中CPU每处理一个字节就要进行一次IO操作，
	// 这样降低了系统效率，而且过于频繁的IO操作对外存储器是一种严峻的考验。

	// 所以引入buffer缓冲区是很有必要的
	private static void copyFileWithBuffer(String src, String dest) throws Exception {
		// 创建读取文件输入流
		FileInputStream in = new FileInputStream(src);
		// 检查输出文件
		File file = new File(dest);
		if (!file.exists()) {
			file.createNewFile();
		}
		// 创建写入文件输出流
		FileOutputStream out = new FileOutputStream(dest);
		
		BufferedInputStream  is = new BufferedInputStream(in);
		BufferedOutputStream os = new BufferedOutputStream(out);
		
		int temp;
		
		while((temp=is.read())!=-1){
			os.write(temp);
		}
		is.close();
		// FilterOutputStream.close()中调用了flush();
		os.close();
		
		System.out.println("copy complated!");
	}

	/**
	 * 利用nio进行文件复制
	 * 
	 * @param src
	 * @param dest
	 * @throws Exception
	 */
	private static void copyFileWithNIO(String src, String dest)
			throws Exception {
		// 创建读取文件输入流
		FileInputStream in = new FileInputStream(src);
		// 检查输出文件
		File file = new File(dest);
		if (!file.exists()) {
			file.createNewFile();
		}
		// 创建写入文件输出流
		FileOutputStream out = new FileOutputStream(dest);

		// 获取输入输出通道
		FileChannel inchannel = in.getChannel();
		FileChannel outchannel = out.getChannel();

		// 创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		while (inchannel.read(buffer) != -1) {
			buffer.flip();
			outchannel.write(buffer);
			buffer.clear();
		}

		inchannel.close();
		outchannel.close();

		System.out.println("copy complated!");
	}

}
