package com.walkerwang.list;

import java.util.ArrayList;

public class EnsureArrayListCapacityTest {
	public static void main(String[] args) {
		final int N = 10000000;
		Object obj = new Object();
		
		/*没有调用ensureCapacity()方法初始化ArrayList对象*/
		ArrayList<Object> list = new ArrayList<>();
		long startTime = System.currentTimeMillis();
		for(int i =0; i <= N; i++) {
			list.add(obj);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("没有调用ensureCapacity()方法所用时间:" + (endTime - startTime) + "ms");
		
		/*调用ensureCapacity()方法初始化ArrayList对象*/
		list = new ArrayList<>();
		startTime = System.currentTimeMillis();
		
		//预先设置list的大小
		list.ensureCapacity(N);
		for(int i = 0; i <= N; i++) {
			list.add(obj);
		}
		endTime = System.currentTimeMillis();
		System.out.println("调用ensureCapacity()方法所用时间：" + (endTime - startTime) + "ms");
	}
}
