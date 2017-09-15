package com.walkerwang.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class test {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(4);
		list.add(2);
		list.add(3);
		list.add(1);
		System.out.println(list);
		
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		System.out.println(list);
		
		Object[] arr = list.toArray();
		int[] a = new int[arr.length];
		for(int i = 0; i < arr.length; i++) 
			a[i] = (int)arr[i];
		quickSort(a, 0, a.length-1);
		System.out.println(a[0]);
		
	}
	
	public static void quickSort(int[] a, int l, int r) {

		if (l < r) {
			int i,j,x;

			i = l;
			j = r;
			x = a[i];
			while (i < j) {
				while(i < j && a[j] > x)
					j--; // 从右向左找第一个小于x的数
				if(i < j)
					a[i++] = a[j];
				while(i < j && a[i] < x)
					i++; // 从左向右找第一个大于x的数
				if(i < j)
					a[j--] = a[i];
			}
			a[i] = x;
			quickSort(a, l, i-1); /* 递归调用 */
			quickSort(a, i+1, r); /* 递归调用 */
		}
	}
	
}