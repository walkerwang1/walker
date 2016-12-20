package com.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * volatile变量自增运算
 * 
 * @author walkerwang
 *
 */
public class VolatileDemo {

	private static volatile int race = 0;
	
	//自增方法
	private static void increase() {
		race++;
	}
	
	//线程数量
	private static final int THREAD_COUNT = 10;
	
	public static void main(String[] args) throws Exception {
//		throughThreadActiveCount();
		throughCountDownLatch();
	}
	
	//使用ThreadActiveCount
	static void throughThreadActiveCount() {
		Thread[] threads = new Thread[THREAD_COUNT];
		for(int i = 0; i < THREAD_COUNT; i++) {
			threads[i] = new Thread( new Runnable() {
				@Override
				public void run() {
					for(int i = 0; i < 1000; i++) {
						increase();
					}
				}
			});
			threads[i].start();
		}
		
		//等待所有类加线程都结束（这个操作似乎也可以用CountDownLatch()模拟）
		while(Thread.activeCount() > 1) {
			Thread.yield();
		}
		
		System.out.println("通过ThreadActiveCount()：" + race);
	}
	
	//使用CountDownLatch
	static void throughCountDownLatch() throws Exception {
		
		CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
		for(int i = 0; i < THREAD_COUNT; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i = 0; i < 1000; i++) {
						increase();
					}
					countDownLatch.countDown();
				}
			}).start();
		}
		countDownLatch.await();
		
		System.out.println("通过CountDownLatch：" + race);
	}
	
	//使用障碍器CyclicBarrier
	static void throughCyclicBarrier() {
		
	}
	
	//使用栅栏
}
