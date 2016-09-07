package com.walkerwang.demo;

public class FinalDemo {
	
	static int a;
	
	public static void main(String[] args) {
		String x = "fmn";
		System.out.println(x.toUpperCase());	//重新分配的一块内存空间
		String y = x.replace('f', 'F');
		y = y + "abc";
		
//		int a;
		final int b=0;	//final变量必须初始化，可以在定义时初始化，也可在构造函数中初始化
		System.out.println(b);
	}
}
