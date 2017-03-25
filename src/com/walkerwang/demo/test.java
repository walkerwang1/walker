package com.walkerwang.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

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
		final int aaa = 0;
		System.out.println(a + " ");
		add(b);
		System.out.println(b + " ");
	}
	public static void main(String[] args) {

		String s = "你好";
		int i = 3;
		System.out.println(s);
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
