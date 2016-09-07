package com.walkerwang.algorithm.swordoffer;

public class TreeDepth1 {
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(1);
		TreeNode treeNode3 = new TreeNode(1);
		TreeNode treeNode4 = new TreeNode(1);
		treeNode1.left = treeNode2;
		treeNode2.left = treeNode3;
		treeNode3.right = treeNode4;
		treeNode4.left = null;
		System.out.println(TreeDepth(treeNode1));
	}
	
	/**
	 * ����ʱ�䣺28ms
		ռ���ڴ棺503k
	 */
	public static int TreeDepth(TreeNode pRoot){
		if (pRoot == null) {
			return 0;
		}
		int left = TreeDepth(pRoot.left);
		int right = TreeDepth(pRoot.right);
		return left>right? (left+1) : (right+1);
	}
}
