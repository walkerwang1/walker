package com.walkerwang.algorithm.swordoffer;

public class ArrayOfKNumber {
	
	public static void main(String[] args) {
		int[] array = {};
		int k = 8;
		System.out.println(GetNumberOfK(array, k));
	}
	
	/**
	 * ����ʱ�䣺36ms
		ռ���ڴ棺528k
	 */
	public static int GetNumberOfK(int [] array , int k){
		int count = 0;
		for(int i=0; i<array.length; i++){
			if (array[i] == k) {
				count++;
			}
		}
		return count;
	}
}
