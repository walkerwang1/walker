package com.walkerwang.algorithm.swordoffer;

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}

public class TreeNodeNext {
	public static void main(String[] args) {
		TreeLinkNode node1 = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		node1.left = node2;
		node1.right = node3;
		node1.next = null;
		node2.left = node4;
		node2.right = node5;
		node2.next = node1;
		node3.left = node3.right = node3.next = null;
		node4.left = node4.right = null;
		node4.next = node2;
		node5.left = node5.right = null;
		node5.next = node2;
		
		TreeLinkNode node = GetNext(node2);
		System.out.println(node.val);
		
	}

	/**
	 * ����ʱ�䣺37ms
		ռ���ڴ棺709k
	 */
	public static TreeLinkNode GetNext(TreeLinkNode pNode) {
		if(pNode == null){
			return null;
		}
		//������������ߵĽڵ�
		if (pNode.right != null) {
			pNode = pNode.right;
			while(pNode.left != null){
				pNode = pNode.left;
			}
			return pNode;
		}
		//�����������ұߵĽڵ�
		while(pNode.next != null){
			if (pNode.next.left == pNode) {
				return pNode.next;
			}
			pNode = pNode.next;
		}
		return null;
	}
}
