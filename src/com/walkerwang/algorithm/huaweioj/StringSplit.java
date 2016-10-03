package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class StringSplit {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		 String str1 = scanner.nextLine();
//		 String str2 = scanner.nextLine();
		int n = scanner.nextInt();
		String[] str = new String[n];
		for(int i=0; i<n; i++){
			str[i] = scanner.next();
		}
		String[] result = splitString(str);
		for(int i=0; i<result.length; i++){
			if (result[i] != null) {
				System.out.println(result[i]);
			}
		}
	}

	public static String[] splitString(String[] string) {
		String[] result = new String[8];
		int count = 0;
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < string.length; i++) {
			String str = string[i];
			while (str.length() >= 8) {
				result[count++] = str.substring(0, 8);
				str = str.substring(8, str.length());
			}
			if (str.length() < 8) {
				result[count++] = str.substring(0, str.length());
			}
		}

		for (int i = 0; i < result.length; i++) {
			if (result[i] != null && result[i].length() != 0) {
				if (result[i].length() < 8) {
					int len = 8 - result[i].length();
					for (int j = 0; j < len; j++) {
						result[i] += "0";
					}
				}
//				sBuilder.append(result[i]);
//				sBuilder.append(" ");
			}
		}
		//去掉sBuilder最后一个空格
		return result;
	}

}
