package com.walkerwang.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueOfferAndPut {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
		try {
			queue.put(1);
			queue.put(2);
			queue.offer(3);
			queue.offer(4);
			queue.put(5);
			queue.offer(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(queue.size());
	}
}
