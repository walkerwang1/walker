package com.walkerwang.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。 
	输入描述:
	输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。


 *递归体：从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串
 *递归出口：只剩一个字符的时候，就不用交换
 *
 */
public class StringPermutation {
	static List<String> list = new ArrayList<>();
	static int count = 0;
	
	public static void main(String[] args) {
		String str = "abc";
		int start = 0;
		int end = str.length()-1;
		permutation(str, start, end);
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println(count);
	}
	
	/*
	 * 将字符串第一位与其他位不断交换，交换一个后递归
	 * （字符串中有重复字符没有考虑到）
	 */
	public static void permutation(String str, int start, int end) {
		
		//递归的出口
		if(start == end){
			list.add(str);
			count++;
		}else{
			for(int i=start; i<=end; i++) {
				char tmp1 = str.charAt(start);
				char tmp2 = str.charAt(i);
				String str1 = str.replace(tmp2, tmp1);
				str = str1.replaceFirst(String.valueOf(tmp1), String.valueOf(tmp2));
				permutation(str, start+1, end);
				tmp1 = str.charAt(start);
				tmp2 = str.charAt(i);
				str1 = str.replace(tmp2, tmp1);
				str = str1.replaceFirst(String.valueOf(tmp1), String.valueOf(tmp2));
			}
		}
	}
}
