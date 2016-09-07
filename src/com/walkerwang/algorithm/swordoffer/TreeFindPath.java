package com.walkerwang.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.Iterator;

public class TreeFindPath {
	public static void main(String[] args) {
		TreeNode treeNode10 = new TreeNode(10);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode7 = new TreeNode(7);
		TreeNode treeNode12 = new TreeNode(12);
		treeNode10.left = treeNode5;
		treeNode10.right = treeNode12;
		treeNode5.left = treeNode4;
		treeNode5.right = treeNode7;
		
		int target = 22;
		ArrayList<ArrayList<Integer>> list = FindPath(treeNode10, target);
		Iterator<ArrayList<Integer>> iterList = list.iterator();
		while(iterList.hasNext()){
			ArrayList<Integer> iter = iterList.next();
			Iterator<Integer> it = iter.iterator();
			while(it.hasNext()){
				int x = it.next();
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	 
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (root == null) 
			return list;
		
		return list;
	}
}
