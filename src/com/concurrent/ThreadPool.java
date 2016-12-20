package com.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Executor执行Runnable任务和Callable任务
 * @author walkerwang
 *
 */
public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		ExecutorService executorService2 = Executors.newCachedThreadPool();
		System.out.println(executorService);
		System.out.println(executorService2);
		
		List<Future<String>> resultList = new ArrayList<>();
		Future<String> future = null;
		for(int i = 0; i < 10; i++) {
			//1-调用Runabl任务
//			executorService.execute(new TestRunnable());
			
			//2-调用Callable任务
			//使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中   
			future = executorService.submit(new TestCallable(i+1));
			//将Callable任务执行结果保存到List中
			resultList.add(future);
		}
		
		/*
		 * 这里体现出执行Runable任务和Callable任务的区别：
		 * （1）Callable有返回值；
		 * （2）返回结果时可以捕获异常
		 */
		Iterator<Future<String>> iter = resultList.iterator();
		while(iter.hasNext()) {
			Future<String> retFuture = iter.next();
			try {
				//如果Future的返回结果没有完成，则一直循环等待（即get()造成阻塞），直到Future返回完成
				while(!retFuture.isDone()){}
				String result = retFuture.get();
				System.out.println(result);	//返回各线程的执行结果
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();	//重新设置线程的中断状态
				future.cancel(true);	//由于不需要结果，因此取消任务
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				/*
				 * ExecutorService生命周期的3中状态：运行关闭和已终止。
				 * 1-shutdown()
				 * 该方法将执行平缓的关闭过程：不再接受新的任务，同时等待已经提交的任务执行完成（包括还未开始执行的任务）
				 * 2-shutdownNown()
				 * 该方法将执行粗暴的关闭过程：它将尝试取消所有运行中的任务，并且不再启动队列中尚未开始执行的任务。
				 */
				executorService.shutdown();
			}
		}
	}
}


class TestRunnable implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName() + "被调用了");
	}
}

class TestCallable implements Callable<String> {
	private int id;
	public TestCallable(int id) {
		this.id = id;
	}
	
	/**
	 * 调用Callable任务的执行过程，一旦Callable对象传递给ExecutorService的submit()方法，
	 * call()方法便会自动在一个线程上执行
	 */
	@Override
	public String call() throws Exception {
		System.out.println(id + "【调用】" +Thread.currentThread().getName());
		//返回结果通过Future的get()方法得到
		return Thread.currentThread().getName() + "【返回结果】";
	}
}
