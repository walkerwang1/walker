package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class StringReverse2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println(reverse2(str));
	}
	
	/**
	 * 使用StringBuilder的函数
	 */
	public static String reverse1(String str){
		StringBuilder sBuilder = new StringBuilder(str);
		sBuilder = sBuilder.reverse();
		return sBuilder.toString();
	}

	/**
	 * 反向遍历字符串
	 */
	public static String reverse2(String str){
		StringBuilder sBuilder = new StringBuilder();
		for(int i=str.length()-1; i>=0; i--){
			sBuilder.append(str.charAt(i));
		}
		return sBuilder.toString();
	}
}
