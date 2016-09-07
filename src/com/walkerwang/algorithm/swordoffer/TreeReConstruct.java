package com.walkerwang.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.Iterator;

public class TreeReConstruct {
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		TreeNode root = reConstructBinaryTree(pre, in);
		ArrayList<Integer> treeList = TreePrint.PrintFromTopToBottom(root);
		Iterator<Integer> iter = treeList.iterator();
		while(iter.hasNext()){
			int val = iter.next();
			System.out.println(val);
		}
	}
	
	/**
	 * ����ʱ�䣺201ms
		ռ���ڴ棺5030k
	 */
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in){
		if(pre == null || in == null){
			return null;
		}
		TreeNode root = preIn(pre,0,pre.length-1,in,0,in.length-1);
		return root;
	}

	private static TreeNode preIn(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
		if (startPre>endPre || startIn>endIn) {
			return null;
		}
		//pre[]�еĵ�һ�����Ǹ��ڵ�
		TreeNode root = new TreeNode(pre[startPre]);
		for(int i=startIn; i<=endIn; i++){
			if(in[i] == pre[startPre]){
				//�ݹ����root������������ע�������±��ֵ
				root.left = preIn(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
				root.right = preIn(pre, startPre+i-startIn+1, endPre, in, i+1, endIn);
			}
		}
		return root;
	}
	
	
}
