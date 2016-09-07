package com.walkerwang.algorithm.swordoffer;

public class StringReverseSentence {
	public static void main(String[] args) {
		String str = " ";
		System.out.println(str.length());
		System.out.println(str +1);
		System.out.println(ReverseSentence(str));
	}

	/**
	 * ����ʱ�䣺38ms
		ռ���ڴ棺503k
	 */
	public static String ReverseSentence(String str) {
		if (str == null ) {
			return null;
		}
		if (str.trim().equals("")) {
			return str;
		}
		String[] strArr = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = strArr.length - 1; i >= 0; i--) {
			sb.append(strArr[i] + " ");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}
}
