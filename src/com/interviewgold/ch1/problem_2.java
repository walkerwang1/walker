package com.interviewgold.ch1;

/*
 * 反转字符串
 */
public class problem_2 {
	public static void main(String[] args) {
		System.out.println(new problem_2().reverse("wk"));
	}
	
	/*
	 * 1-交换字符数组的首位和末尾
	 */
	public String solution01(String str) {
		System.out.println("内置方法：" + new StringBuilder(str).reverse());
		System.out.println(new StringBuffer(str).reverse());
		int i=0;
		char[] chs = str.toCharArray();
		int end = chs.length-1;
		while(i<end) {
			char tmp;
			tmp = chs[i];
			chs[i] = chs[end];
			chs[end] = tmp;
			i++;
			end--;
		}
		return String.valueOf(chs);
	}
	
	public String reverse1(String str) {
		char[] value = str.toCharArray();
		int n = value.length-1;
		for(int i=(n-1)/2; i>=0; i--)  {
			char tmp = value[i];
			value[i] = value[n-i];
			value[n-i] = tmp;
		}
		return String.valueOf(value);
	}
	
	public String reverse(String str) {
		return new StringBuffer(str).reverse().toString();
	}
}
