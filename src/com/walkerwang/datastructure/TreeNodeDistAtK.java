package com.walkerwang.datastructure;

/*
 * http://www.acmerblog.com/nodes-distance-k-given-node-6004.html
 */

public class TreeNodeDistAtK {
	static class Node {
		int data;
		Node left, right;

		public Node(int i) {
			this.data = i;
		}
	}
	
	//打印以root为根的二叉树中，到target距离为k的节点
	public static int KDistNode(Node root, Node target, int k){
		if(root == null)
			return -1;
		
		if(root == target){
			KDistNodeDown(root, k);
			return 0;
		}
		
		int dis_left = KDistNode(root.left, target, k);
		if(dis_left != -1){
			if(dis_left + 1 == k)
				System.out.println(root.data);
			else
				//左右孩子之间相差两个距离
				KDistNodeDown(root.right, k-dis_left-2);
			return dis_left +1;
		}
		
		int dis_right = KDistNode(root.right, target, k);
		if(dis_right != -1)
		{
			if(dis_right +1 == k)
				System.out.println(root.data);
			else
				KDistNodeDown(root.left, k-dis_right-2);
			return dis_right + 1;
		}
		
		return -1;
	}
	
	//找到root子树下面的所有距离为k的节点
	public static void KDistNodeDown(Node root, int k){
		if(root == null || k < 0)
			return;
		if(k == 0){
			System.out.println(root.data);
			return;
		}
		KDistNodeDown(root.left, k-1);
		KDistNodeDown(root.right, k-1);
	}
	
	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(20);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		Node target = root.left;
		int k = 2;
		KDistNode(root, target, k);
	}
}
