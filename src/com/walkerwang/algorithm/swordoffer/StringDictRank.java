package com.walkerwang.algorithm.swordoffer;

import java.util.ArrayList;

public class StringDictRank {

	public static void main(String[] args) {
		String str = "abc";
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++)
			System.out.print(ch[i] + " ");
		// ArrayList<String> list = Permutation(str);
		// for(String string : list){
		// System.out.println(string);
		// }
	}

	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> list = new ArrayList<>();
		if (str.equals("") || str == null)
			return list;
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {

		}
		return list;
	}
}
