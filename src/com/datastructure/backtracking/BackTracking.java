package com.datastructure.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking {
	
	List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		BackTracking backTracking = new BackTracking();
		
		/*
		 * 1-排列组合，从元素不重复的数组中随机取k个数。
		 */
		int[] arr = {1,2,3,3,4};
		int k = 3;
		backTracking.combine(0, k, arr);
		
		/*
		 * 2-n个数字的全排列
		int[] arr = {1,2,3,4};
		backTracking.permute(0, arr);
		 */

		/*
		 * 3-集合的子集问题
		 int[] arr = {1,2,3};
		for(int k= 1; k <= arr.length; k++){
			backTracking.subSet(0,k,arr);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		ArrayList<ArrayList<Integer>> allsubsets = backTracking.subSet2(list);  
        for(ArrayList<Integer> set : allsubsets){  
            System.out.println(set);  
        } 
		 */
	}
	
	/*
	 * 1-排列组合，从元素不重复的数组中随机取k个数。（如果数组中包含重复元素怎么处理？）
	 */
	public void combine(int idx, int k, int[] arr) {
		if (k == 1) {
			for(int i = idx; i < arr.length; i++) {
				list.add(arr[i]);
				System.out.println(list.toString());
				list.remove((Object)arr[i]);
			}
		}else if (k > 1){
			for(int i = idx; i <= arr.length - k; i++) {
				list.add(arr[i]);
				
				combine(i+1, k-1, arr);		//回溯体（画出递归结构）
				
				list.remove((Object)arr[i]);
			}
		}
	}
	
	/*
	 * 2-n个不重复数字的全排列
	 */
	public void permute(int idx, int[] arr) {
		if (idx >= arr.length) {
			//输出
			System.out.println(Arrays.toString(arr));
		}
		for(int i = idx; i < arr.length; i++) {
			//交换a[i]和a[idx]
			{int tmp = arr[idx]; arr[idx] = arr[i]; arr[i] = tmp;}
			
			permute(idx+1, arr);
			
			{int tmp = arr[idx]; arr[idx] = arr[i]; arr[i] = tmp;}
		}
	}
	
	/*
	 * 3-1:集合的子集问题（类似组合问题1），子集分为空和非空。（下面的处理方式只包含非空的情况，对于空的情况需要额外添加进去）
	 */
	public void subSet(int index, int k, int[] arr) {
		if(k == 1) {
			for(int i = index; i < arr.length; i++) {
				list.add(arr[i]);
				System.out.println(list);
				list.remove((Object)arr[i]);
			}
		} else {
			for(int i = index; i <= arr.length - k; i++) {
				list.add(arr[i]);
				
				subSet(i+1, k-1, arr);
				
				list.remove((Object)arr[i]);
			}
		}
	}
	
	/*
	 * 3-2:集合的子集问题。2^n个解。000,001,010,011……
	 */
	public ArrayList<ArrayList<Integer>> subSet2(ArrayList<Integer> list) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<>();
		int max = 1 << list.size();
		for(int i = 0; i < max; i++) {
			ArrayList<Integer> s = new ArrayList<>();
			int index = 0;  
            int k = i;  
            while(k > 0){  
                if((k&1) > 0){  
                    s.add(list.get(index));  
                }  
                k>>=1;  
                index++;  
            }
			allsubsets.add(s);
		}
		return allsubsets;
	}
}
