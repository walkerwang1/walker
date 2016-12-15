package com.walkerwang.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 阻塞队列、阻塞栈
 * 
 * 总结：阻塞队列、阻塞栈底层实现结构还是跟普通的队列、栈一样，只是添加了“阻塞”限制，并是线程安全的
 * 
 * @author walkerwang
 *
 */
public class BlockingQueueAndDeque {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueueAndDeque demo1 = new BlockingQueueAndDeque();
		demo1.BlockingQueueTest();	//阻塞队列
		demo1.BlockingDequeTest();	//阻塞栈
	}

	/*
	 * 阻塞队列
	 */
	void BlockingQueueTest() throws InterruptedException {
		BlockingQueue<String> bqueue = new ArrayBlockingQueue<>(10);

		for(int i=1; i<=20; i++) {
			//将指定元素添加到阻塞队列中
			bqueue.put("" + i);
			if (bqueue.size() > 8) {
				//从队列中获取队头元素，并将其移出队列
				System.out.println("取出元素：" + bqueue.take());
			}
			System.out.println("向阻塞队里中添加了元素：" + i);
		}
		System.out.println("程序到此运行结束，即将推出……");
	}
	
	/*
	 * 阻塞栈
	 */
	void BlockingDequeTest() throws InterruptedException {
		BlockingDeque<String> bdeque = new LinkedBlockingDeque<>(10);
		
		for(int i=1; i<=20; i++) {
			//将指定元素添加到此栈中
//			bdeque.addFirst("" + i);	//报错“Deque full”
			bdeque.putFirst("" + i);
			if (bdeque.size() > 8) {
				//从栈中获取栈顶元素，并将其移出栈
				System.out.println("取出元素" + bdeque.poll());
			}
			System.out.println("向阻塞栈中添加了元素：" + i);
		}
		System.out.println("程序到此运行结束，即将推出……");
	}
}
