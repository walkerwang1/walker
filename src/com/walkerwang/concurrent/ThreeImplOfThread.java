package com.walkerwang.concurrent;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

//继承Thread类
public class ThreeImplOfThread extends Thread {
	@Override
	public void run() {
		for(int i=0; i<2; i++){
			System.out.println("myThread1");
		}
	}
	
	public static void main(String[] args) {
		ThreeImplOfThread mt1 = new ThreeImplOfThread();
		mt1.start();
		
		MyThread2 mt2 = new MyThread2();
		new Thread(mt2).start();
		
		MyThread3 mt3 = new MyThread3();;
		FutureTask<String> task1 = new FutureTask<>(mt3);
		new Thread(task1).start();
		
		Executor service = Executors.newCachedThreadPool();
		service.execute(mt1);
		service.execute(task1);
		
		try {
		System.out.println(task1.get()); 	//获得返回值ֵ
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}

//实现Runnable接口
class MyThread2 implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<2; i++){
			System.out.println("myThread2");
		}
	}
}

//实现Callable接口
class MyThread3 implements Callable<String>{
	
	@Override
	public String call() throws Exception {
		System.out.println(1111);
		return "wang";
	}
}
