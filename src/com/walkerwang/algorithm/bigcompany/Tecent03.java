package com.walkerwang.algorithm.bigcompany;

import java.util.Scanner;

/**
 * [编程题] 构造回文
 * 
	给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
	输出需要删除的字符个数。
	
	输入描述:
	
	输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
	
	输出描述:
	
	对于每组数据，输出一个整数，代表最少需要删除的字符个数。
	
	输入例子:
	abcda
	google
	
	输出例子:
	2
	2
 *
 */
public class Tecent03 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = new StringBuilder(str1).reverse().toString();
		System.out.println(str1.length()-LCS(str1, str2));
	}
	
	public static int LCS(String str1, String str2) {
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int[][] c = new int[chs1.length+1][chs2.length+1];
		for(int i=0; i<=chs1.length; i++) {
			c[i][0] = 0;
		}
		for(int i=0; i<=chs2.length; i++) {
			c[0][i] = 0;
		}
		for(int i=1; i<=str1.length(); i++) {
			for(int j=1; j<=str2.length(); j++) {
				if(chs1[i-1] == chs2[j-1]){
					c[i][j] = c[i-1][j-1] +1;
				}else if (c[i-1][j] >= c[i][j-1]) {
					c[i][j] = c[i-1][j];
				}else {
					c[i][j] = c[i][j-1];
				}
			}
		}
		
		return c[chs1.length][chs2.length];
	}
}
