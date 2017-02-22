package com.datastructure;

/*
 * 递归算法汇总
 * 
 * 1-递归出口
 * 2-递归体
 * 
 * 递归算法<--->非递归算法
 */
public class RecursionAlg {
	
	public static void main(String[] args) {
		/*字符串的全排列
		String str = "abc";
		int start = 0;
		int end = str.length()-1;
		permutation(str, start, end);
		*/
		
		/*求树的高度
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(1);
		TreeNode treeNode3 = new TreeNode(1);
		TreeNode treeNode4 = new TreeNode(1);
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode3.right = treeNode4;
		treeNode4.left = null;
		System.out.println(getDepth(treeNode1));
		 */
		
		/*反转单链表
		 * 
		 */
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = null;
		Util.printList(listReverse2(listNode1));
	}
	
	/*
	 *反转单链表（递归）
	 *参考链接：http://blog.csdn.net/guyuealian/article/details/51119499
	 */
	public static ListNode listReverse(ListNode head) {
		if(head.next == null || head == null) {
			return head;
		}
		ListNode node = listReverse(head.next);
		head.next.next = head;
		head.next = null;
		return node;
	}
	/*
	 *反转单链表（非递归）
	 *参考链接：http://blog.csdn.net/guyuealian/article/details/51119499
	 *1：遍历反转
	 *2：头插法
	 */
	public static ListNode listReverse2(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode pre, cur, tmp;	//tmp临时节点，保存cur节点的指针域，即cur.next
		pre = head;
		cur = head.next;
		while(cur != null) {
			tmp = cur.next;
			cur.next = pre;
			
			//指针往下移
			pre = cur;
			cur = tmp;
		}
		//最后将原链表的头节点指针域设置为null，返回新链表的头节点，即原链表的尾节点
		head.next = null;
		return pre;
	}
	

	/*
	 * 字符串的全排列（递归）
	 * (字符串-->字符数组处理； 改进交换字符串中两个字符的位置)
	 */
	public static void permutation(String str, int start, int end) {
		// 递归的出口
		if (start == end) {
			System.out.println(str);
		} else {
			for (int i = start; i <= end; i++) {  
				//交换两个位置(2134)
				char tmp1 = str.charAt(start);
				char tmp2 = str.charAt(i);
				String str1 = str.replace(tmp2, tmp1);
				str = str1.replaceFirst(String.valueOf(tmp1), String.valueOf(tmp2));

				permutation(str, start + 1, end);	//递归体

				//交换两字符后重新还原其顺序(1234)
				tmp1 = str.charAt(start);
				tmp2 = str.charAt(i);
				str1 = str.replace(tmp2, tmp1);
				str = str1.replaceFirst(String.valueOf(tmp1), String.valueOf(tmp2));
			}
		}
	}
	
	/*
	 * 求树的高度
	 */
	public static int getDepth(TreeNode root) {
		//递归出口
		if(root == null){
			return 0;
		}
		int left = getDepth(root.left);		//递归体
		int right = getDepth(root.right);
		return left >= right ? (left+1) : (right +1);
	}
	
	
	/*
	 * 遍历树
	 */
}
