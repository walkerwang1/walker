package com.walkerwang.algorithm.swordoffer;

import java.util.ArrayList;

public class ArrayMaxInWindows {

	public static void main(String[] args) {
		int[] num = {2,3,4,2,6,2,5,1};
		int size = 3;
		ArrayList<Integer> list = maxInWindows(num, size);
		for(int x : list){
			System.out.print(x + " ");
		}
	}
	
	/**
	 * ����ʱ�䣺32ms
		ռ���ڴ棺503k
	 */
	public static ArrayList<Integer> maxInWindows(int [] num, int size){
		ArrayList<Integer> list = new ArrayList<>();
		if (size == 0) {
			return list;
		}
		if (num.length < size) {
			return list;
		}
		int totalnum = num.length - size + 1;
		for(int i=0; i<totalnum; i++)
		{
			int max = num[i];
			for(int j=i; j<size+i; j++)
			{
				if (num[j] > max) {
					max = num[j];
				}
			}
			list.add(max);
		}
		return list;
	}
	
	public static int maxValue(int a, int b, int c){
		if(a>=b && a>=c)
			return a;
		if (b>=a && b>=c) 
			return b;
		if (c>=a && c>=b) 
			return c;
		return Integer.MIN_VALUE;
	}
}
