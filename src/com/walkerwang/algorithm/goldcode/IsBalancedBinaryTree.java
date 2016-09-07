package com.walkerwang.algorithm.goldcode;

/**
 * 二叉树平衡检查
 * 
 * 题目描述

实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 * @author walkerwang
 *
 */
public class IsBalancedBinaryTree {
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(1);
		TreeNode treeNode3 = new TreeNode(1);
		TreeNode treeNode4 = new TreeNode(1);
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode3.right = treeNode4;
		treeNode4.left = null;
		System.out.println(IsBalanced(treeNode1));
	}
	
	static boolean IsBalanced(TreeNode root) {
		if(root == null){
			return true;
		}
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		if(Math.abs(left-right) <= 1) 
			return true;
		return IsBalanced(root.left) && IsBalanced(root.right);
	}
	
	static int getDepth(TreeNode root) {
		if(root == null)
			return 0;
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		return left > right ? left+1 : right+1;
	}
}
