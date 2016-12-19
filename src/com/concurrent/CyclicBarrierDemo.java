package com.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 障碍器
 * @author walkerwang
 *
 */
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		//创建CyclicBarrier对象
		//并设置执行完一组5个线程的并发任务后，再执行MainTask任务
		CyclicBarrier cb = new CyclicBarrier(5, new MainTask());
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new SubTask("A", cb));
		executorService.execute(new SubTask("B", cb));
		executorService.execute(new SubTask("C", cb));
		executorService.execute(new SubTask("D", cb));
		executorService.execute(new SubTask("E", cb));
	}
}

/*
 * 执行最后任务
 */
class MainTask extends Thread {
	@Override
	public void run() {
		System.out.println("……终于要执行最后的任务了……");
	}
}

/*
 * 一组并发任务
 */
class SubTask implements Runnable {
	private String name;
	private CyclicBarrier cb;

	public SubTask(String name, CyclicBarrier cb) {
		this.name = name;
		this.cb = cb;
	}
	
	@Override
	public void run() {
		System.out.println("【并发任务" + name + "】 开始执行");
		//模拟耗时的任务
		for(int i=0; i < 999999; i++) {}
		System.out.println("【并发任务" + name + "】 开始执行完毕，通知障碍器");
		try {
			//每执行完一项任务就通知障碍器
			cb.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
}