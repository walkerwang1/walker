package com.walkerwang.algorithm.swordoffer;

public class ListReverse {
	public static void main(String[] args) {
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
		ListNode head = reverseList(listNode1);
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		
	}
	
	public static ListNode reverseList(ListNode head){
		ListNode cur, p;
		p = cur = head;
		head = null;
		while(p != null){
			cur = p;
			p = p.next;
			cur.next = head;
			head = cur;
		}
		return head;
	}
}
