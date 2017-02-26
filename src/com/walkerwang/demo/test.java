package com.walkerwang.demo;

import java.util.Stack;

public class test extends Object {
	
	public static void main(String[] args) {
		Father a = new child();
		a.print();
		
		Stack<Integer> stack;
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
