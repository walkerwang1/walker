package com.walkerwang.demo;

public class test extends Object {
	
	public static void add(Integer b) {
		b = b++;
	}
	
	public static void test (){
//		Byte a = 127;
//		Byte b = 127;
		Integer a  =127;
		Integer b = 127;
		add(++a);
		System.out.println(a + " ");
		add(b);
		System.out.println(b + " ");
	}
	public static void main(String[] args) {
		test();
	}
	
	
}

class Father {
	void print() {
		System.out.println("father");
	}
}

class child extends Father {
	@Override
	void print() {
		System.out.println("child");
	}
}
