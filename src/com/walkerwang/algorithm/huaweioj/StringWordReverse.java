package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class StringWordReverse {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println(wordReverse(str));
	}

	/**
	 * 这里还存在一个问题，即对于两个单词之间若存在多个空格，反转后还是有多个空格，如何治保留一个空格？？
	 * @param str
	 * @return
	 */
	public static String wordReverse(String str){
		if(str.equals(" ")){
			return null;
		}
		StringBuilder sBuilder = new StringBuilder();
		String[] chs = str.split(" ");
		for(int i=chs.length-1; i>=0; i--){
			sBuilder.append(chs[i]);
			sBuilder.append(" ");
		}
		//去掉sBuilder最后一个空格
		return sBuilder.toString().substring(0, sBuilder.length()-1);
	}
}
