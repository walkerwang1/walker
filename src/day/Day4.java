package day;

import java.util.ArrayList;
import java.util.List;

public class Day4 {

	public static void main(String[] args) {
		Day4 day4 = new Day4();
//		int[] arr = {1,-2,3,10,-4,7,2,-5};
		int[] arr = {-2,-1,-3};
		System.out.println(day4.conSubArray(arr));
	}
	
	/*
	 * 求子数组的最大和
		题目描述：
		输入一个整形数组，数组里有正数也有负数。
		数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
		求所有子数组的和的最大值。要求时间复杂度为O(n)。
		例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2，
		因此输出为该子数组的和18。
	 */
	public int conSubArray(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		int start_index = 0;
		int end_index = -1;
		for(int i = 0; i < arr.length; i++) {
			int v = arr[i];
			currSum += v;
			if (currSum < v) {		//如果和比当前数字小，则从当前数字重新开始
				currSum = v;
				start_index = i;
			}
			if (currSum > maxSum) {
				maxSum = currSum;
				end_index = i;
			}
		}
		System.out.println(start_index);
		System.out.println(end_index);
		return maxSum;
	}
}
