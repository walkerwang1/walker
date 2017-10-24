package day.month10;

import java.util.ArrayList;
import java.util.List;

public class Day5 {
	
	public static void main(String[] args) {
		
		Day5 day5 = new Day5();
		/*
		 * 3-集合的子集问题
		 * */
		 int[] arr = {1,2,3};
		for(int k= 1; k <= arr.length; k++){
			day5.subSet(0,k,arr);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		ArrayList<ArrayList<Integer>> allsubsets = day5.subSet2(list);  
        for(ArrayList<Integer> set : allsubsets){  
            System.out.println(set);  
        } 
	}
	
	
	List<Integer> list = new ArrayList<>();
	
	
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
