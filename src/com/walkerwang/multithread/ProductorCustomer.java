package com.walkerwang.multithread;

class Info{
	private String title;
	private String content;
	private boolean flag = true;	
	//true表示可以生产，但是不可以取走；false表示可以取走，但是不可以生产
	public synchronized void set(String title, String content){
		//重复进入到了set（）方法里面，发现不能够生产，所以要等待
		if (flag == false) {
			try {
				super.wait();	//线程等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.title = title;
		try {
			Thread.sleep(200);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.content = content;
		this.flag = false;
		super.notify();		//唤醒其他线程
	}
	
	public synchronized void get(){
		//还没生产
		if(this.flag == true){
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.title + "-" + this.content);
		this.flag = true;
		super.notify();
	}
}

class Productor implements Runnable {
	private Info info;
	public Productor(Info info) {
		this.info = info;
	}
	@Override
	public void run() {
		for(int x = 0; x<100; ++x){
			if (x % 2 == 0) {
				this.info.set("wang","好学生一枚");
			} else {
				this.info.set("康","bad student");
			}
		}
	}
}


class Customer implements Runnable {
	private Info info;
	public Customer(Info info) {
		this.info = info;
	}
	@Override
	public void run() {
		for(int x=0; x<100; ++x){
			this.info.get();
		}
	}
	
}

public class ProductorCustomer {
	public static void main(String[] args) {
		Info info = new Info();
		Productor p1 = new Productor(info);
		Customer c1 = new Customer(info);
		new Thread(p1).start();
		new Thread(c1).start();
//		new Thread(new Productor(info)).start();
//		new Thread(new Customer(info)).start();
	}
}
