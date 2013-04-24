package com.alibaba.webx.study.thread;

/**
 * 继承Thread
 * 
 * 虽然我们在这里调用的是start（）方法，但是实际上调用的还是run（）方法的主体
 * 
 * @author zhaoyuanli
 *
 */
public class ExtendsThreadTest extends Thread {
	
	private String name;
	
	public ExtendsThreadTest(String name){
		this.name= name;
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(name+":"+i);
			if(i==3){
				 System.out.println("线程的礼让");
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) {
		ExtendsThreadTest e1 = new ExtendsThreadTest("e1");
		ExtendsThreadTest e2 = new ExtendsThreadTest("e2");
		// 调用方法不对,还是按顺序运行
//		e1.run(); 
//		e2.run(); 
		
		// 因为需要用到CPU的资源，所以每次的运行结果基本是都不一样的
		e1.start();
		e2.start();
	}

}
