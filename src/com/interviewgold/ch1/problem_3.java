package com.interviewgold.ch1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 给定两个字符串，判断一个字符串的字符重新排列后能都变成另外一个字符串（即两个字符串排序后相等）
 */
public class problem_3 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abcc";
		System.out.println(new problem_3().solution01(str1, str2));
		System.out.println(new problem_3().solution02(str1, str2));
		System.out.println(new problem_3().solution03(str1, str2));
	}
	
	/*
	 * 1-HashMap
	 */
	public boolean solution01(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		char[] chs1 = str1.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : chs1) {
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			} else {
				map.put(ch, 1);
			}
		}
		
		
		for(int i=0; i<str2.length(); i++) {
			char ch = (char)str2.charAt(i);
			if(!map.containsKey(ch)){
				return false;
			} else{
				int num =  map.get(ch)-1;
				if(num < 0 ) return false;
				map.put(ch, num);
			}
		}
		return true;
	}
	
	
	/*
	 * 2-检查两个字符串是的各字符是否相同
	 */
	public boolean solution02(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		int[] letters = new int[256];
		char[] chs1 = str1.toCharArray();
		for(char ch : chs1) {
			letters[ch]++;
		}
		for(int i=0; i<str2.length(); i++) {
			char ch = (char)str2.charAt(i);
			if(--letters[ch] < 0) {		//str2中存在str1没有的字符
				return false;
			}
		}
		return true;
	}
	
	/*
	 * 3-对字符串进行排序，两个字符串相等
	 */
	public boolean solution03(String str1, String str2) {
		if(str1.length() != str2.length()){
			return false;
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		Arrays.sort(chs1);
		Arrays.sort(chs2);
//		System.out.println(chs1);
//		System.out.println(chs2);
		for(int i=0; i<chs1.length; i++) {
			if(chs1[i] == chs2[i]) {
//				System.out.println(chs1[i] + ":" + chs2[i]);
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
