package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		String result = reverse(inputString);
		System.out.println(result);
	}
	
	public static String reverse(String str){
		if (str == null) {
			return null;
		}
		StringBuilder sBuilder = new StringBuilder();
		for(int i=str.length()-1; i>=0; i--){
			char ch = str.charAt(i);
			if(ch != ' '){
				sBuilder.append(ch);
			}else {
				sBuilder.append(ch);
			}
		}
		return sBuilder.toString();
	}
}	
