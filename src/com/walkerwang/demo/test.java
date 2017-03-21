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
		StringBuilder sbBuilder;
		StringBuffer sBuffer;
		String str1 = "haIlo";
		String str2 = "haeeo";
		str1 = str1.substring(0);
		Object obj2;
		
		String s = "ab";  
		String s1 = "a";  
		String s2 = s1 + "b";  
		String s3 = "ab";   
		System.out.println(s == s2);//false  
		System.out.println(s2 == s3);//false  
		System.out.println(s2.hashCode() == s3.hashCode());   
		System.out.println(s2 == s3);
		
		Integer i1 = 50;
		Integer i2 = 50;
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
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
