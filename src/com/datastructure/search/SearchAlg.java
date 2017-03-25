package com.datastructure.search;

/*
 * 查找算法
 * 
 */
public class SearchAlg {
	public static void main(String[] args) {
		SearchAlg searchAlg = new SearchAlg();
		int[] arr = {1,2,3,4,5,6,8};
		System.out.println(searchAlg.binary_search(arr, 9));
	}
	
	/**
	 * 二分查找
	 */
	public int binary_search(int[] arr, int val) {
		int beginIndex = 0;
		int endIndex = arr.length - 1;
		int midIndex = -1;
		while(beginIndex <= endIndex) {
			midIndex = beginIndex + (endIndex - beginIndex) / 2;
			if (arr[midIndex] == val) {
				return midIndex;
			} else if (arr[midIndex] < val) {
				beginIndex = midIndex + 1;
			} else {
				endIndex = midIndex - 1;
			}
		}
		
		return -1;
	}
}
