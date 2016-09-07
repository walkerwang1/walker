package com.walkerwang.algorithm.swordoffer;

public class StringLeftRotate {

	public static void main(String[] args) {
		String str = "";
		int n = 6;
		LeftRotateString(str, n);
	}

	/**
	 * ����ʱ�䣺34ms
		ռ���ڴ棺503k
	 */
	public static String LeftRotateString(String str, int n) {
		if (str == null || n>str.length()) {
			return str;
		}
		String substr = str.substring(0, n);
		System.out.println(substr);
		StringBuilder sb = new StringBuilder(str.substring(n,str.length()));
		sb.append(substr);
		System.out.println(sb.toString());
		return sb.toString();
	}
}
