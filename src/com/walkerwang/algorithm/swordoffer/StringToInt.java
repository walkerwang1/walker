package com.walkerwang.algorithm.swordoffer;

public class StringToInt {
	public static void main(String[] args) {
		String str = " ";
		int result = StrToInt(str);
		System.out.println(result);
	}
	
	/**
	 * ����ʱ�䣺33ms
		ռ���ڴ棺654k
	 */
	public static int StrToInt(String str){
		if (str == null || str.equals("")) {
			return 0;
		}
		int result = 0;
		boolean flag = false;
		/*
		 * '0'->48
		 * '1'->49
		 */
//		result = Integer.parseInt(str);
		char[] ch = str.toCharArray();
		for(int i=0; i<ch.length; i++)
		{	
			if(ch[i] == '-'){
				flag = true;
				continue;
			}
			if (ch[i] == '+') {
				continue;
			}
			if (ch[i] <48 || ch[i] > 57) {
				return 0;
			}
			result = result*10 + ch[i] - '0';
		}
		if (flag) {
			result = -result;
		}
		return result;
	}
}
