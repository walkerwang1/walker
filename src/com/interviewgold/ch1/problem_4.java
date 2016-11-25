package com.interviewgold.ch1;

import java.util.Arrays;

/*
 * 把字符串中的所有空格替换为"%20"，使用字符数组实现
 */
public class problem_4 {
	public static void main(String[] args) {
		String str = "I am St ";
		System.out.println(new problem_4().solution01(str));
	}
	
	/*
	 * 1-先对数组扩容
	 */
	public String solution01(String str){
		char[] chs = str.toCharArray();
		int spaceCount = 0;
		for(int i=0; i<chs.length; i++) {
			if(chs[i] == ' '){
				spaceCount++;
			}
		}
		int newMaxIndex = chs.length + spaceCount*2;
		chs = Arrays.copyOf(chs, newMaxIndex);		//字符数组扩容
//		chs[newMaxIndex+1] = '\0';
		for(int i=str.length()-1; i>=0; i--) {
			if(chs[i] == ' ') {
				chs[newMaxIndex-1] = '0';
				chs[newMaxIndex-2] = '2';
				chs[newMaxIndex-3] = '%';
				newMaxIndex = newMaxIndex - 3;
			} else {
				chs[newMaxIndex-1] = chs[i];
				newMaxIndex--;
			}
		}
		return String.valueOf(chs);
	}
}
