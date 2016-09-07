package com.walkerwang.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.Iterator;

public class AlContinuousSeq {
	public static void main(String[] args) {
		int sum = 15;
		FindContinuousSequence(sum);
	}

	/**
	 * ����ʱ�䣺36ms
		ռ���ڴ棺629k
	 */
	public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=(sum/2); i++){
			int s = 0;
			int j;
			for(j=i; s<sum; j++){
				s += j;
			}
			j--;
			if (s == sum) {
				for(int k=i; k<=j; k++){
					list.add(k);
				}
				result.add(new ArrayList<Integer>(list));
			}
			list.clear();
		}
		if (result.size() == 0) {
			return result;
		}
		System.out.println(result.size());
		System.out.println(result);
		Iterator<ArrayList<Integer>> it = result.iterator();
		while(it.hasNext()){
			ArrayList<Integer> list2 = it.next();
			Iterator<Integer> it2 = list2.iterator();
			while(it2.hasNext()){
				int x = it2.next();
				System.out.print(x+" ");
			}
			System.out.println();
		}
		return result;
	}
}
