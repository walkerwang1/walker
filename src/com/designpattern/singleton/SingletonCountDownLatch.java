package com.designpattern.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试单例模式在多线程环境下的效率
 * @author walkerwang
 *
 */
public class SingletonCountDownLatch {
	
	public static void main(String[] args) throws Exception{
		
		long starttime = System.currentTimeMillis();
		
		int THREADNUM = 10;	  //线程数量
		//CountDownLatch是一个同步工具类，允许一个或多个线程一直等待，直达其他线程的操作执行完后再执行
		CountDownLatch countDownLatch = new CountDownLatch(THREADNUM);
		
		for(int i=0; i<10; i++) {
			new Thread(new Runnable() {
				public void run() {
					for(int i=0; i<1000; i++) {
						InnerClassSingleton2 s1 = InnerClassSingleton2.getInstance();
					}
					countDownLatch.countDown();
				}
			}).start();
		}
		countDownLatch.await();
		Class<InnerClassSingleton2> clazz = (Class<InnerClassSingleton2>)Class.forName("com.designpattern.singleton.InnerClassSingleton2");
		System.out.println(clazz + ":\n" + (System.currentTimeMillis()-starttime) + "ms") ;
	}
	
}

class InnerClassSingleton2 {
	
	
	private InnerClassSingleton2(){}
	
	private static class SingleHoder {
		private static InnerClassSingleton2 instance = new InnerClassSingleton2();
	}
	
	public static InnerClassSingleton2 getInstance() {
		return SingleHoder.instance;
	}
}
