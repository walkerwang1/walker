package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class StringChSort {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String str = "Ihave1nose2hands10fingers";
//		String str = scanner.nextLine();
		char[] arr = str.toCharArray();
		quickSort(arr, 0, arr.length-1);
		StringBuilder sBuilder = new StringBuilder();
		for(int i=0; i<arr.length; i++){
			sBuilder.append(arr[i]);
		}
		System.out.println(sBuilder.toString());
	}
	
	public static void quickSort(char[] arr, int left, int right){
		if(left >=right)
			return;
		char tmp = arr[left];
		int i,j;
		i = left;
		j = right;
		while(i != j){
			//这两个while循环顺序不能颠倒，要先从j开始遍历
			while(i<j && arr[j]>=tmp){
				j--;
			}
			while(i<j && arr[i]<=tmp){
				i++;
			}
			if(i < j){
				char t;
				t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		//基准a[left]归位（其实就是a[left]和a[i]交换）
		arr[left] = arr[i];
		arr[i] = tmp;
		
		quickSort(arr, left, i-1);
		quickSort(arr, i+1, right);
	}
}
