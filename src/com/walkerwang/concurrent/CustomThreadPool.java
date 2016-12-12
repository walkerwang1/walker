package com.walkerwang.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 * @author walkerwang
 */
public class CustomThreadPool {
	
	public static void main(String[] args) {
		//线程池中所保存的核心线程数，包括空闲线程
		int corePoolSize = 3;	
		//线程池中允许的最大线程数（什么时候最大线程会起作用）
		int maximumPoolSize = 5;
		//线程池中空闲线程所能持续的最大时间
		long keepAliveTime = 50;
		//持续时间的单位
		TimeUnit unit = TimeUnit.MILLISECONDS;
		//任务执行前保存任务的队列，仅保存由execute方法提交的Runnable任务
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(20);
		ThreadPoolExecutor pool = new ThreadPoolExecutor(
				corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		
		Runnable t1 = new TestRunnable();
		for(int i=0; i<10; i++) {
			pool.execute(t1);
		}
	}
}

