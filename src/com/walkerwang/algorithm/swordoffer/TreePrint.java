package com.walkerwang.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	
	public TreeNode(int val) {
		this.val = val;
	}
}

public class TreePrint {
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.left = treeNode4;
		treeNode2.right = treeNode5;
		treeNode3.left = treeNode6;
		ArrayList<Integer> treeList = PrintFromTopToBottom(treeNode1);
		Iterator<Integer> iter = treeList.iterator();
		while(iter.hasNext()){
			int val = iter.next();
			System.out.print(val+" ");
		}
	}
	
	/**
	 * ����ʱ�䣺33ms
		ռ���ڴ棺654k
	 */
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
		ArrayList<Integer> list = new ArrayList<>();
		if(root == null){
			return list;
		}
		Queue<TreeNode> deque = new LinkedList<TreeNode>();
		deque.add(root);
		while(!deque.isEmpty()){
			TreeNode t = deque.poll();
			list.add(t.val);
			if(t.left != null){
				deque.add(t.left);
			}
			if(t.right != null){
				deque.add(t.right);
			}
		}
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()){
			int val = iter.next();
			System.out.print(val+" ");
		}
		return list;
	}
}
