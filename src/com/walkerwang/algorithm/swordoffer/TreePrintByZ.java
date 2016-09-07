package com.walkerwang.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TreePrintByZ {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node4.right = null;
		node5.left = node5.right = null;
		node6.left = node6.right = null;
		node7.left = node7.right = null;
		
		ArrayList<ArrayList<Integer>> aList = Print(node1);
		for(ArrayList<Integer> list : aList){
			Iterator<Integer> iter = list.iterator();
			while(iter.hasNext()){
				int x = iter.next();
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	/**
	 * ����ʱ�䣺37ms
		ռ���ڴ棺688k
	 */
	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
		if (pRoot == null) {
			return aList;
		}
		Stack<TreeNode> s1 = new Stack<>();
		s1.add(pRoot);
		Stack<TreeNode> s2 = new Stack<>();
		while(!s1.isEmpty() || !s2.isEmpty()){
			if (!s1.isEmpty()) {
				ArrayList<Integer> list = new ArrayList<>();
				//s1
				while(!s1.isEmpty()){
					TreeNode node = s1.pop();
					list.add(node.val);
					if (node.left != null) {
						s2.add(node.left);
					}
					if (node.right != null) {
						s2.add(node.right);
					}
				}
				aList.add(list);
			}else{
				ArrayList<Integer> list = new ArrayList<>();
				//s2
				while(!s2.isEmpty()){
					TreeNode node = s2.pop();
					list.add(node.val);
					if (node.right!= null) {
						s1.add(node.right);
					}
					if (node.left != null) {
						s1.add(node.left);
					}
				}
				aList.add(list);
			}
		}
		return aList;
	}
}
