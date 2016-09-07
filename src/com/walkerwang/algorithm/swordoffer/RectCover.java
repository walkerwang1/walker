package com.walkerwang.algorithm.swordoffer;

public class RectCover {
	public static void main(String[] args) {
		System.out.println(rectCover(4));
	}
	
	/**
	 * ����ʱ�䣺733ms
		ռ���ڴ棺654k
	 */
	public static int rectCover(int target){
		if(target <= 0){
			return 0;
		}else{
			if(target == 1){
				return 1;
			}else if(target == 2){
				return 2;
			}else {
				return rectCover(target-1) + rectCover(target-2);
			}
		}
	}
}
