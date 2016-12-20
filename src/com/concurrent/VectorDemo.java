package com.concurrent;

import java.util.Vector;

public class VectorDemo {

	private static Vector<Integer> vector = new Vector<>();
	
	public static void main(String[] args) {
		while(true) {
			for(int i = 0; i < 10; i++) {
				vector.add(i);
			}
			
			Thread removeThread = new Thread(new Runnable() {

				@Override
				public void run() {
					synchronized (vector) {
						for(int i = 0; i < vector.size(); i++){
							vector.remove(i);
						}
					}
				}
			});
			
			Thread printThread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					//这里如果不加同步，还是线程不安全的，当一个线程错误的时间里删除了一个元素，
					//导致序号i已经不再可用，访问时就会出现数组越界异常
					synchronized (vector) {
						for(int i = 0; i < vector.size(); i++){
							System.out.println(vector.get(i));
						}
					}
				}
			});
			
			removeThread.start();
			printThread.start();
			
			//不要同时产生过多的线程，否则会导致操作系统假死
			while(Thread.activeCount() > 20) {}
		}
	}
}
