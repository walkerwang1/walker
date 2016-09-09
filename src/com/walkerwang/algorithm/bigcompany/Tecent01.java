package com.walkerwang.algorithm.bigcompany;

import java.util.Scanner;

/**
 * 算法基础-字符移位
 * 
 * 小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
	你能帮帮小Q吗？
	
	输入描述:
	
	输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
	  
	输出描述:
	
	对于每组数据，输出移位后的字符串。
	
	输入例子:
	AkleBiCeilD
	
	输出例子:
	kleieilABCD
 * @author walkerwang
 *
 */
public class Tecent01 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
//		while(scanner.hasNext()) {
//			String str = scanner.nextLine();
			String str = "AEleBiCeilD";
			bubbleSort(str);
			moveBack(str);
//		}
	}
	
	//改进的冒泡排序
	public static void bubbleSort(String str) {
		char[] chs = str.toCharArray();
		//从尾部开始需要第一个不是大写的字符
		int i = chs.length-1;
		while(chs[i] >= 65 && chs[i] <= 90) {
			i--;
		}
		
		for(; i>=0; i--){
			for(int j=1; j<=i; j++) {
				if((chs[j-1] >= 65 && chs[j-1] <= 90) && (chs[j] >= 97 && chs[j] <= 122)) {
					char tmp = chs[j-1];
					chs[j-1] = chs[j];
					chs[j] = tmp;
				}
			}
		}
		
		System.out.println(String.valueOf(chs));
	}
	
	/*
	 * 数组移位
	 *  运行时间： 35 ms 占用内存：279K
	 */
	public static void moveBack(String str) {
		boolean flag = false;	//flag用于标记是否移动了
		char[] chs = str.toCharArray();
		int count = 0; 	//调整的大写字符个数，每调整一次，遍历的长度就减1
		for(int i=0; i<chs.length-count; i++) {
			flag = false;	
			if(chs[i] >=65 && chs[i] <= 90) {
				char tmp = chs[i];
				for(int j=i+1; j<chs.length; j++) {	//大写字符之后的字符前移
					chs[j-1] = chs[j];
				}
				chs[chs.length-1] = tmp;	//该大写字符放到最后
				flag = true;
				count++;
//				if(flag == true)
//					System.out.println(String.valueOf(chs));
				i--;
			}
		}
		System.out.println(String.valueOf(chs));
	}
}
