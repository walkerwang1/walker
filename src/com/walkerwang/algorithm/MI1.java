package com.walkerwang.algorithm;

import java.util.Scanner;

public class MI1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()) {
			String str = in.nextLine();
		
		String[] arrs = str.split(" ");
		
		StringBuilder sb = new StringBuilder();
		for(int i = arrs.length-1; i >= 0; i--) {
			sb.append(arrs[i] + " ");
		}
		String ret = sb.toString().substring(0, sb.length()-1);
		System.out.println(ret);
	}
	}
}
