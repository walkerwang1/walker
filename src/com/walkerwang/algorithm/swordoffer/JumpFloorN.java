package com.walkerwang.algorithm.swordoffer;

public class JumpFloorN {
	public static void main(String[] args) {
		int target = 5;
		System.out.println(JumpFloor(target));
		System.out.println(JumpFloorII(target));
	}

	/**
	 * 1-һ����1����2�� ����ʱ�䣺557ms ռ���ڴ棺503k
	 */
	public static int JumpFloor(int target) {
		if (target <= 0) {
			return 0;
		} else if (target == 1) {
			return 1;
		} else if (target == 2) {
			return 2;
		} else {
			return JumpFloor(target - 1) + JumpFloor(target - 2);
		}
	}

	/**
	 * 2-һ����1����2������n��
	 * ����ʱ�䣺33ms
		ռ���ڴ棺629k
	 */
	public static int JumpFloorII(int target) {
		if (target == 0) {
			return 0;
		}

		int[] aar = new int[target + 1];
		aar[0] = 1;
		aar[1] = 1;

		for (int i = 2; i <= target; i++) {
			aar[i] = 0;
			for (int j = 0; j < i; j++) {
				aar[i] += aar[j];
			}
		}

		return aar[target];
	}
}
