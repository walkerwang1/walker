package com.walkerwang.demo;

public class StringSwapDemo {
	public static void main(String[] args) {
		String str = "wangkang";
		char[] chs = str.toCharArray();
		swap(chs,0,4);
		System.out.println(String.valueOf(chs));
	}
	
	public static void swap(char[] chs, int start, int end) {
		char tmp = chs[start];
		chs[start] = chs[end];
		chs[end] = tmp;
	}
}
