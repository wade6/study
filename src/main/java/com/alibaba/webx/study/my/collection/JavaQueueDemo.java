package com.alibaba.webx.study.my.collection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java队列
 * <p>
 * 
 * 在java5中新增加了java.util.Queue接口，用以支持队列的常见操作。该接口扩展了java.util.Collection接口。
 * Queue使用时要尽量避免Collection的add
 * ()和remove()方法，而是要使用offer()来加入元素，使用poll()来获取并移出元素。它们的优
 * 点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。 如果要使用前端而不移出该元素，使用
 * element()或者peek()方法。 值得注意的是LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
 * 
 * 输出结果：
 * <p>
 * 3 HelloWorld!你好！ 0
 * 
 * @author zhaoyuanli
 * 
 */
public class JavaQueueDemo {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("Hello");
		queue.offer("World!");
		queue.offer("你好！");
		System.out.println(queue.size());
		String str;
		while ((str = queue.poll()) != null) {
			System.out.print(str);
		}
		System.out.println();
		System.out.println(queue.size());
	}
}
