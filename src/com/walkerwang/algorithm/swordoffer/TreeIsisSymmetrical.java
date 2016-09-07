package com.walkerwang.algorithm.swordoffer;

public class TreeIsisSymmetrical {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(1);
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
		System.out.println("ԭ����");
		TreePrint.PrintFromTopToBottom(node1);
		System.out.println();

		boolean flag = isSymmetrical(node1);
		System.out.println(flag);
	}

	/**
	 * ����ʱ�䣺30ms
		ռ���ڴ棺629k
	 */
	static boolean isSymmetrical(TreeNode pRoot) {
		// ������
		TreeNode root = getMirror(pRoot);
		System.out.println("��������");
		TreePrint.PrintFromTopToBottom(root);
		System.out.println();
		return isSymmetrical(pRoot, root);
	}

	// �ж�ԭ���;������ǲ���һ����
	public static boolean isSymmetrical(TreeNode pRoot, TreeNode root) {

		if (pRoot == null && root == null) {
			return true;
		}
		if (pRoot == null || root == null) {
			return false;
		}
		if (pRoot.val == root.val) {
			return (isSymmetrical(pRoot.left, root.left) && isSymmetrical(pRoot.right, root.right));
		}
		return false;
	}

	// ��ԭ���ľ�����(���õݹ飬��ѭ������ʵ�����񣿣���
	// root��һ�á��¡�������Ҫ���¸��������ڴ档
	//ԭ�������ṹ���䣬���¹�����һ����
	public static TreeNode getMirror(TreeNode pRoot) {
		if (pRoot == null) {
			return null;
		}
		TreeNode root = new TreeNode(pRoot.val);
		root.left = getMirror(pRoot.right);
		root.right = getMirror(pRoot.left);
		return root;
	}
	
	//������2
	//ֱ����ԭ�������ϲ������ı���ԭ�������Ľṹ
	public void Mirror(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        TreeNode tmp = null;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        if(root.left!=null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);
    }
}
