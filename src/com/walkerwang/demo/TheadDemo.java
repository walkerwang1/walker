package com.walkerwang.demo;

public class TheadDemo extends Thread{

	@Override
	public void run() {
		while(true) {
			send("wang");
		}
	}
	
	public void send(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		TheadDemo theadDemo = new TheadDemo();
		theadDemo.start();
	}
}
