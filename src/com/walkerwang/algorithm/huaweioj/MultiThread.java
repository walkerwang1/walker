package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class MultiThread{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		 int times = scanner.nextInt();
//		int times = 4;
		int count = 1;
		while (count <= times) {
			MyThread e1 = new MyThread("A");
			MyThread e2 = new MyThread("B");
			MyThread e3 = new MyThread("C");
			MyThread e4 = new MyThread("D");

			try {
				e1.start();
				e1.join();	//join()的作用是线程e1执行完后，等待其他线程执行完才能继续执行
				e2.start();
				e2.join();
				e3.start();
				e3.join();
				e4.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++;
		}
	}
	
	private static class MyThread extends Thread{

		private String name; 	//线程名

		public MyThread() {
		}

		public MyThread(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.print(name);
		}
	}
}
