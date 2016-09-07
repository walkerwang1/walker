package com.walkerwang.algorithm.swordoffer;

public class ArrayReOrder {
	public static void main(String[] args) {
		int[] array = { 2, 5, 61, 6, 7, 13, 6, 223 };
		/**
		 * {1,2,3,4,5,6,7,8,9,10};
		 */
		// output:{1,3,5,7,9,2,4,6,8,10}
		// ż������Ϊ�����ŵ���
		reOrderArray(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	/**
	 * ����ʱ�䣺38ms
		ռ���ڴ棺654k
	 */
	public static void reOrderArray(int[] array) {
		if (array.length == 0) {
			return;
		}
		for (int i = 1; i <= array.length - 1; i++)
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
					int tmp;
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
	}
}
