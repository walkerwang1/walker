package day.month9;

import java.util.Arrays;

public class Day5 {

	public static void main(String[] args) {
		Day5 day5 = new Day5();
		int[] arr = {1,3,4,5,9,10,12,14,15,20};
		int x = 24;
		int[] result = day5.sum(arr, x);
		for(int i = 0; i < result.length-1; i=i+2) {
			if (result[0] == 0) {
				System.out.println(-1);
				break;
			}
			if (result[i] != 0) {
				System.out.println(arr[result[i]] + ":" + arr[result[i+1]]);
			}
		}
	}
	
	/*
	 * 一个正整数的有序有组Array=[1,3,4,5,9,10,12,14,15,20]，一个是正整数x=24，
	 * 要实现的功能：找到所有符合条件“任意俩元素和为x”的元素下标，并把结果返回回来。
	 */
	public int[] sum(int[] arr, int x) {
		int[] result = new int[arr.length];
		int i = 0;
		int j = arr.length - 1;
		int k = 0;
		int a = arr[i];
		int b = arr[j];
		//两边同时扫描
		while(i != j) {
			if (a + b == x) {
				result[k++] = i++;
				result[k++] = j;
				a = arr[i];
				continue;
			}
			while(a + b > x) {
				b = arr[--j];
			}
			while(a + b < x) {
				a = arr[++i];
			}
		}
		return result;
	}
	
	public void sum2(int[] arr, int sum) {
		Arrays.sort(arr);
		int first = 0;
		int last = arr.length - 1;
		while(first < last) {
			int s = arr[first] + arr[last];
			if (s == sum) {
				first++;
				last--;
			} else {
				if (s < sum) {
					first++;
				} else {
					last--;
				}
			}
		}
	}
}
