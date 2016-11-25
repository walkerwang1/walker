package com.interviewgold.ch1;

/*
 * 字符串压缩
 */
public class problem_5 {

	public static void main(String[] args) {
		String str = "abcdefg";
		System.out.println(new problem_5().solution01(str));
	}
	
	/*
	 * 1-直接把当前字符与接下来的字符进行比较（“快行指针”）
	 */
	public String solution01(String str) {
		StringBuilder sb = new StringBuilder();
		char[] chs = str.toCharArray();
		int i=0, j, count;
		while(i<chs.length) {
			j = i+1;
			count = 1;
			while(j<chs.length && chs[j] == chs[i]) {
				count++;
				j++;
			}
			sb.append(chs[i] +""+ count);
			i = j;
		}
		
		return (sb.length()<chs.length) ? sb.toString() : str;
	}
}
