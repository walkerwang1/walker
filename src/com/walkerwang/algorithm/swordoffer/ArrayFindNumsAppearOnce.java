package com.walkerwang.algorithm.swordoffer;

public class ArrayFindNumsAppearOnce {
	public static void main(String[] args) {
		int[] array = { 0, 2, 4, 2, 3, 5, 4, 5};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		FindNumsAppearOnce(array, num1, num2);
	}

	/**
	 * ����ʱ�䣺36ms
		ռ���ڴ棺654k
	 */
	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array.length <= 1) {
			return;
		}
		int[] nums = new int[array.length];
		int count = 1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i != j) {
					if (array[j] == array[i]) {
						count++;
					}
				}
			}
			if (count == 1) {
				nums[i] = array[i];
			}
			count = 1;
		}
		//�����������ֻ��һ��Ϊ0�����ҳ���Ϊ0����һ����
		for(int i=0; i<nums.length; i++){
			if (nums[i] != 0) {
				num1[0] = nums[i];
				break;
			}
		}
		//���ڵڶ�������Ҫ�ж����ǲ���0
		for(int i=0; i<nums.length; i++){
			if (nums[i] != num1[0]) {
				if (nums[i] != 0) {
					num2[0] = nums[i];
					break;
				}
				if (i == nums.length-1) {
					num2[0] = nums[i];
				}
			}
		}
		System.out.println(num1[0] + " " + num2[0]);
	}
}
