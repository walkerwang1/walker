package com.datastructure;

/*
 * http://www.acmerblog.com/distance-between-given-keys-5995.html
 */

public class TreeNodeDist {
	
	//返回node节点在root中的第几层，-1表示没有在root子树下找到
	private static int findLevel(TreeNode root, int node) {
		if(root == null)
			return -1;
		if(root.val == node)
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
	private static TreeNode findLCA(TreeNode root, int node1, int node2) {
		if(root == null)
			return null;
		//找到两个节点中的一个就返回
		if(root.val== node1 || root.val == node2)
			return root;
		
		//分别在左右子树查找两个节点
		TreeNode left_lca = findLCA(root.left, node1, node2);
		TreeNode right_lca = findLCA(root.right, node1, node2);
		
		if(left_lca != null && right_lca != null){
			//两个节点肯定是分别在左右子树中，当前节点比为LCA
			return root;
		}
		return left_lca != null ? left_lca : right_lca;
	}

	public static int distanceNodes(TreeNode root, int node1, int node2){
		TreeNode lca = findLCA(root, node1, node2);
		int dis_lca = findLevel(root, lca.val);
		int dis1 = findLevel(root, node1);
		int dis2 = findLevel(root, node2);
		System.out.println("LCA:" + lca.val);
		System.out.println("dis1:" + dis1 + "; dis2:" + dis2 + "; dis_lca:" + dis_lca);
		int dist = dis1 + dis2 - 2*dis_lca;
		return dist;
	}
	

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);

		System.out.println("Dist(8,7) = " + distanceNodes(root, 8, 7));
		System.out.println("Dist(8,3) = " + distanceNodes(root, 8, 3));
		System.out.println("Dist(8,2) = " + distanceNodes(root, 8, 2));

	}
}
