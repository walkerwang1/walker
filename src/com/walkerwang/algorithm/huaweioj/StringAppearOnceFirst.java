package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class StringAppearOnceFirst {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println(findChar(str));
	}
	
	public static char findChar(String str){
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			//如果字符ch只出现一次，则返回ch
			if(getCount(str, ch) == 1){
				return ch;
			}
		}
		return '.';
	}
	
	//统计某个字符出现的次数
	public static int getCount(String str, char ch){
		int count = 0;
		for(int i=0; i<str.length(); i++){
			if(ch == str.charAt(i)){
				count++;
			}
		}
		return count;
	}
}
