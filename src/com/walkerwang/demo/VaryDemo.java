package com.walkerwang.demo;

public class VaryDemo {
	public static void main(String[] args) {
		VaryDemo demo  = new VaryDemo();
		int j = 0, i;
//		demo.add(++);
		i = ++j;
		System.out.println(i);
	}
	
	void add(int i ) {
		i++;
	}
}
