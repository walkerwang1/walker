package com.walkerwang.algorithm.bigcompany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*微信红包
 * 
	题目描述

	春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，
	某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。
	写出具体算法思路和代码实现，要求算法尽可能高效。
	给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
	若没有金额超过总数的一半，返回0。
	
	测试样例：
	[1,2,3,2,2],5
	返回：2
 */
public class Tecent04_Gift {

	public static void main(String[] args) {
		int[] gifts = { 1, 2, 2, 3, 3, 3 };
		int n = 6;

		System.out.println(new Tecent04_Gift().getValue2(gifts, n));
	}

	public int getValue(int[] gifts, int n) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(gifts[i])) {
				map.put(gifts[i], map.get(gifts[i]) + 1);
			} else {
				map.put(gifts[i], 1);
			}
		}

		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		for (Entry<Integer, Integer> e : list) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}

		int count1 = list.get(0).getValue();
		int count2 = list.get(1).getValue();
		if (count1 == count2 || count1 <= n / 2) {
			return 0;
		} else {
			return list.get(0).getKey();
		}
	}

	/*
	 * 还未看懂
	 */
	public int getValue2(int[] gifts, int n) {
		int count = 1;
		int re = gifts[0];
		for (int i = 1; i < n; i++) {
			if (gifts[i] != re) {
				count--;
				if (count == 0) {
					count = 1;
					re = gifts[i];
				}

			} else {
				count++;
			}
		}
		System.out.println("count:"+count);
		count = 0;
		for (int i = 0; i < n; i++) {
			if (gifts[i] == re) {
				count++;
			}
		}
		if (count > n / 2) {
			return re;
		} else
			return 0;
	}

	/*
	 * 先排序，如果要求个数过半，则说明中间的的那个数一定是出现次数最多的红包
	 */
	public int getValue3(int[] gifts, int n) {
//		Arrays.sort(gifts);
		quicksort(gifts, 0, n-1);
		int ans = gifts[n / 2];
		int num = 0;
		for (int i = 0; i < gifts.length; i++) {
			if (gifts[i] == ans) {
				num++;
			}
		}
		return num <= n / 2 ? 0 : ans;
	}
	
	
	//快排
	public void quicksort(int[] arr, int left, int rihgt){
		if(left >= rihgt)
			return;
		int tmp = arr[left];
		int i = left;
		int j = rihgt;
		while(i != j) {
			while(i<j && arr[j]>=tmp){
				j--;
			}
			while(i<j && arr[i]<=tmp) {
				i++;
			}
			if(i < j) {
//				swap(arr, i, j);
				int a = arr[i];
				arr[i] = arr[j];
				arr[j] = arr[i];
			}
		}
		arr[left] = arr[i];
		arr[i] = tmp;
		
		quicksort(arr, left, i-1);
		quicksort(arr, i+1, rihgt);
	}
}
