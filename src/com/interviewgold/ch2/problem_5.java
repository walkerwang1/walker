package com.interviewgold.ch2;


/**
 * 给定两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是“个位”排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * 
 * 进阶：
 * 假设这些数位是正向存放的
 * @author walkerwang
 *
 */
public class problem_5 {
	
	public static void main(String[] args) {
		Node node11 = new Node(6);
		Node node12 = new Node(1);
		Node node13 = new Node(7);
		Node node14 = new Node(1);
		node11.next = node12; node12.next = node13; node13.next = node14;
		
		Node node21 = new Node(2);
		Node node22 = new Node(9);
		Node node23 = new Node(5);
		node21.next = node22; node22.next = node23;
		
		Node ret = new problem_5().addLists(node11, node21);
		ListUtil.printLinkedList(ret);
		
		
	}
	
	/*
	 * 1-低位在链表表头--递归
	 */
	public Node addLists(Node l1, Node l2, int carry) {
		//两个链表全部空且进位为0，则函数返回
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}
		Node result = new Node();
		//将value以及l1和l2的data相加
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		
		result.data = value % 10;	//求和结果的个位数
		
		//递归
		Node more = addLists(l1 == null ? null : l1.next, 
				l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
		result.next = more;
		return result;
	}
	
	/*
	 * 2进阶-低位在链表表尾
	 */
	public Node addLists(Node l1, Node l2) {
		int len1 = getLen(l1);
		int len2 = getLen(l2);
		
		//用零填充较短的链表
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}
		
		//对两个链表求和
		PartialSum sum = addListsHelper(l1, l2);
		
		//如有进位，则插入链表首部，否则，直接返回整个链表
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	
	PartialSum addListsHelper(Node l1, Node l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		//对较少数字递归求和
		PartialSum sum = addListsHelper(l1.next, l2.next);
		
		//将进位和当前数据相加
		int val = sum.carry + l1.data + l2.data;
		
		//插入当前数字的求和结果
		Node full_result = insertBefore(sum.sum, val % 10);
		
		//返回求和结果和进位值
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}
	
	/**
	 * 用零填充链表
	 * @param l
	 * @param padding
	 * @return
	 */
	Node padList(Node l, int padding) {
		Node head = l;
		for(int i = 0; i < padding; i++) {
			Node n = new Node(0);
			n.next = head;
			head = n;
		}
		return head;
	}
	
	/**
	 * 辅助函数，将结点插入链表首部
	 * @param list
	 * @param data
	 * @return
	 */
	Node insertBefore(Node list, int data) {
		Node node = new Node(data);
		if (list != null) {
			node.next = list;
		}
		return node;
	}
	
	/**
	 * 获取链表长度
	 * @param head
	 * @return
	 */
	public int getLen(Node head) {
		int count = 0;
		while(head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
}

class PartialSum {
	public Node sum = null;
	public int carry = 0;
}
