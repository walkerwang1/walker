package day.month10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {
	
	List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		/*
		 * 1-排列组合，从元素不重复的数组中随机取k个数。
		int[] arr = {1,2,3,4};
		int k = 3;
		backTracking.combine(0, k, arr);
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
}
