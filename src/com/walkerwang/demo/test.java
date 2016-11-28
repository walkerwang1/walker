package com.walkerwang.demo;

import java.util.ArrayList;
import java.util.Arrays;

public class test extends Object {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "kang";
	}
	
	public static void main(String[] args) {
		//1-ArrayList
		ArrayList aList = new ArrayList<>();
		
		
		String string = "wang";
		System.out.println(string);
		char[] chs = string.toCharArray();
//		System.out.println(chs);
//		string = Arrays.toString(chs);
		System.out.println(chs.toString());
	}
}
