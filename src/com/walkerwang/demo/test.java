package com.walkerwang.demo;

public class test extends Object {
	
	public static void main(String[] args) {
		Father a = new child();
		a.print();
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
