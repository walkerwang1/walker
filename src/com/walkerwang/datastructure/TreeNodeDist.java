package com.walkerwang.datastructure;

/*
 * http://www.acmerblog.com/distance-between-given-keys-5995.html
 */

class Node {
	Node left, right;
	int key;

	public Node(int i) {
		this.key = i;
	}
}

public class TreeNodeDist {
	
	//返回node节点在root中的第几层，-1表示没有在root子树下找到
	private static int findLevel(Node root, int node) {
		if(root == null)
			return -1;
		if(root.key == node)
			return 0;
		
		//先在左子树查找
		int level = findLevel(root.left, node);
		//左子树没有找到则到右子树查找
		if(level == -1)
			level = findLevel(root.right, node);
		if(level != -1)
			return level+1;
		return -1;
	}
	
	//寻找最低公共祖先LCA
	private static Node findLCA(Node root, int node1, int node2) {
		if(root == null)
			return null;
		//找到两个节点中的一个就返回
		if(root.key == node1 || root.key == node2)
			return root;
		
		//分别在左右子树查找两个节点
		Node left_lca = findLCA(root.left, node1, node2);
		Node right_lca = findLCA(root.right, node1, node2);
		
		if(left_lca != null && right_lca != null){
			//两个节点肯定是分别在左右子树中，当前节点比为LCA
			return root;
		}
		return left_lca != null ? left_lca : right_lca;
	}

	public static int distanceNodes(Node root, int node1, int node2){
		Node lca = findLCA(root, node1, node2);
		int dis_lca = findLevel(root, lca.key);
		int dis1 = findLevel(root, node1);
		int dis2 = findLevel(root, node2);
		System.out.println("LCA:" + lca.key);
		System.out.println("dis1:" + dis1 + "; dis2:" + dis2 + "; dis_lca:" + dis_lca);
		int dist = dis1 + dis2 - 2*dis_lca;
		return dist;
	}
	

	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);

		System.out.println("Dist(8,7) = " + distanceNodes(root, 8, 7));
		System.out.println("Dist(8,3) = " + distanceNodes(root, 8, 3));
		System.out.println("Dist(8,2) = " + distanceNodes(root, 8, 2));

	}
}
