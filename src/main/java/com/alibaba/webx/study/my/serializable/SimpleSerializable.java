package com.alibaba.webx.study.my.serializable;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.alibaba.citrus.util.io.ByteArrayInputStream;

/**
 * 序列化对象，保存到本地文件中，读取文件进行反序列化
 * 
 * static和transient变量被序列化的时候，并不会序列化
 * 
 * @author zhaoyuan.lizy
 *
 */
public class SimpleSerializable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4622445778714272070L;

	private int version;
	
	private transient String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String fileName = "d:\\object.out";
		FileOutputStream fo = new FileOutputStream(fileName); // 文件
		ByteArrayOutputStream bo = new ByteArrayOutputStream(); // 内存
		
		ObjectOutputStream oo = new ObjectOutputStream(fo); // 装饰object写
		ObjectOutputStream oo2 = new ObjectOutputStream(bo);// 装饰object写
		
		SimpleSerializable object = new SimpleSerializable(); // 生成object
		object.setVersion(12);
		object.setName("test");
		
		System.out.println("before:");
		System.out.println(object.getVersion());
		System.out.println(object.getName());
		System.out.println(object.toString());
		
		oo.writeObject(object);// 写文件
		oo.close();
		
		object.setVersion(13);
		oo2.writeObject(object);// 写内存
		byte[] data = bo.toByteArray();// 从内存获取数据
		oo2.close();
		
		ObjectInputStream oi = new ObjectInputStream(new FileInputStream(fileName));
		ObjectInputStream oi2 = new ObjectInputStream(new ByteArrayInputStream(data));
		
		SimpleSerializable obj = (SimpleSerializable) oi.readObject();
		SimpleSerializable obj2 = (SimpleSerializable) oi2.readObject();
		System.out.println("after:");
		
		System.out.println("   file--");
		System.out.println(obj.getVersion());
		System.out.println(obj.getName());
		System.out.println(obj.toString());
		
		System.out.println("   memory--");// 深度克隆
		System.out.println(obj2.getVersion());
		System.out.println(obj2.getName());
		System.out.println(obj2.toString());
		
	}
	
}
