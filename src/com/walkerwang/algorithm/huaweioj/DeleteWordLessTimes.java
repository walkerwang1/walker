package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class DeleteWordLessTimes {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		String str = scanner.nextLine();
		String str = "abcdd";
		System.out.println(getWord(str));
	}
	
	public static String getWord(String str){
		int[] count = new int[26];
		//统计某个字符出现的次数
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			count[ch-'a']++;	//下标为字符对应的数字(a->0, b->1 ……)
		}
//		for(int i=0; i<str.length(); i++){
//			if(count[i] != 0)		//删除出现次数为min的字母
//				System.out.println(str.charAt(i) + ":" + count[i]);
//		}
		
		int min = Integer.MAX_VALUE;  //记录出现次数最小的字母
		StringBuilder sBuilder = new StringBuilder();
		for(int i=0; i<count.length; i++){
			if(count[i] != 0 && count[i] < min){
				min = count[i];
			}
		}
//		System.out.println("min:" + min);
		for(int i=0; i<str.length(); i++){
			if(count[str.charAt(i)-'a'] != min)		//删除出现次数为min的字母
				sBuilder.append(str.charAt(i));
		}
		System.out.println(sBuilder.toString());
		return sBuilder.toString();
	}
}
