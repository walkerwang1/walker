package com.walkerwang.concurrent;

public class ProducerConsumer {

	/*
	 * 生产者-消费者存在的问题：
	 * 	1：一条消息还没有生产完就被消费，即"姓名-1  内容-2",两条消息交替出现。
	 * 	 同步机制：即生产的时候不能消费
	 *  2：只生产n条信息，却消费m条，m>n
	 *  线程通信：当没有生产消息时不能消费
	 */
	public static void main(String[] args) {
		
		Info info = new Info();
		Producer producer = new Producer(info);
		Consumer consumer = new Consumer(info);
		
		new Thread(producer).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(consumer).start();
	}
}

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

class Producer implements Runnable {
	private Info info;
	public Producer(Info info) {
		this.info = info;
	}
	@Override
	public void run() {
		for(int x = 0; x<100; ++x){
			if (x % 2 == 0) {
				this.info.set("标题-1","内容-1");
			} else {
				this.info.set("标题-2","内容-2");
			}
		}
	}
}


class Consumer implements Runnable {
	private Info info;
	public Consumer(Info info) {
		this.info = info;
	}
	@Override
	public void run() {
		for(int x=0; x<100; ++x){
			this.info.get();
		}
	}
	
}
