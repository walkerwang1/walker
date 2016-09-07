package com.walkerwang.algorithm.goldcode;

/**高度最小的BST
 * 
 * 题目描述

对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。
给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
 * @author walkerwang
 *
 */
public class BSTofMinHigh {
	public static void main(String[] args) {
		int[] vals = {1,2,3,4,5,6,7,8};
		System.out.println(buildMinimalBST(vals));
	}
	
	public static int buildMinimalBST(int[] vals) {
		if(vals == null || vals.length < 1) 
			return 0;
		return build(vals, 0, vals.length);
    }
	
	public static int build(int[] vals, int start, int end) {
		if(end <= start){
			return 1;
		}
		int mid = (start+end)/2;
		int height1 = 1 + build(vals, start, mid-1);
		int height2 = 1 + build(vals, mid+1, end);
		return height1 > height2 ? height1 : height2;
	}
	
}
