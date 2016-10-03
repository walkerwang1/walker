package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class StringChMatch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		System.out.println(boolIsAllCharExist(str1, str2));
	}
	
	/**
	 *短字符串str1中的所有字符出现在长字符串str2中即可，不需要连续 
	 */
	static boolean boolIsAllCharExist(String str1, String str2){
		boolean result = true;
		for(int i=0; i<str1.length(); i++){
			char ch = str1.charAt(i);
			if(str2.indexOf(ch) < 0){
				result = false;
				break;
			}
		}
		return result;
	}
}
