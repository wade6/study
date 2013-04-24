package com.alibaba.webx.study.thread;

/**
 * 实现Runnable接口
 * 
 * 如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。
 * 
 * 实现Runnable接口比继承Thread类所具有的优势：
 *  1）：适合多个相同的程序代码的线程去处理同一个资源
 *  2）：可以避免java中的单继承的限制
 *  3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立。
 * 
 * @author zhaoyuanli
 *
 */
public class ImplRunnableTest implements Runnable {

	private String name;
	
	private int num;
	
	public ImplRunnableTest(String name){
		this.name = name;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	@Override
	public void run() {
//		for(int i=0;i<5;i++){
//			System.out.println(name+":"+i);
//		}
		while(num>0){
			System.out.println(Thread.currentThread().getName()+"拿到："+num--);
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		ImplRunnableTest r1 = new ImplRunnableTest("r1");
		// 共享这个数字
		r1.setNum(10);
//		ImplRunnableTest r2 = new ImplRunnableTest("r2");
		
		Thread t1 = new Thread(r1,"t1");
		Thread t2 = new Thread(r1,"t2");
		Thread t3 = new Thread(r1,"t3");
//		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		t3.start();
		System.out.println("main end");
	}

}
