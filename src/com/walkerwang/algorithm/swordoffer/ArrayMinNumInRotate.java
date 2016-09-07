package com.walkerwang.algorithm.swordoffer;

public class ArrayMinNumInRotate {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		/**
		 * {1,2,3,,4,5}
		 * {3,4,5,1,2}
		 */
		System.out.println(minNumberInRotateArray(arr));
		System.out.println(minNumberInRotateArray2(arr));
	}
	
	//1-������Сֵ
	public static int minNumberInRotateArray(int[] array){
		if(array.length == 0)
			return 0;
		int min = array[0];
		for(int i=0; i<array.length; ++i){
			if(array[i] < min){
				min = array[i];
			}
		}
		return min;
	}
	
	//2-�ҵ�һ�Խ����������
	public static int minNumberInRotateArray2(int[] array){
		if (array.length == 0) {
			return 0;
		}
		for(int i=0; i<array.length-1; ++i){
			if(array[i]>array[i+1]){
				return array[i+1];
			}else{
				if(i==array.length-2){
					return array[0];
				}
			}
		}
		return 0;
	}
}
