package com.walkerwang.algorithm.swordoffer;

public class TreeBalanced {
	
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
	
	/**
	 * 运行时间：37ms
		占用内存：654k
	 */
	public static boolean IsBalanced(TreeNode root){
		if (root == null) {
			return true;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		if(Math.abs(left-right) > 1){
			return false;
		}
		//分别判断左右二叉树是不是平衡二叉树
		return IsBalanced(root.left) && IsBalanced(root.right);
	}
	
	public static int depth(TreeNode root){
		if(root == null){
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		return left>right? (left+1) : (right+1);
	}
}
