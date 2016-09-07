package com.walkerwang.algorithm.swordoffer;

public class ListMerge {
	public static void main(String[] args) {
		ListNode listNode11 = new ListNode(1);
		ListNode listNode12 = new ListNode(3);
		ListNode listNode13 = new ListNode(5);
		ListNode listNode14 = new ListNode(7);
		ListNode listNode15 = new ListNode(9);
		listNode11.next = listNode12;
		listNode12.next = listNode13;
		listNode13.next = listNode14;
		listNode14.next = listNode15;
		listNode15.next = null;

		ListNode listNode21 = new ListNode(2);
		ListNode listNode22 = new ListNode(4);
		ListNode listNode23 = new ListNode(6);
		ListNode listNode24 = new ListNode(8);
		ListNode listNode25 = new ListNode(10);
		listNode21.next = listNode22;
		listNode22.next = listNode23;
		listNode23.next = listNode24;
		listNode24.next = listNode25;
		listNode25.next = null;

		ListNode head = mergeList(listNode11, listNode21);
		ListNode p = head;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
	}

	public static ListNode mergeList(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null)
			return null;
		if (list1 == null)
			return list2;
		if (list2 == null) {
			return list1;
		}
		ListNode head = new ListNode(-1);
		ListNode tail = head;
		while (list1 != null && list2 != null) {
			if (list1.val >= list2.val) {
				tail.next = list2;
				tail = tail.next;
				list2 = list2.next;
			} else {
				tail.next = list1;
				tail = tail.next;
				list1 = list1.next;
			}
		}

		if (list1 != null) {
			tail.next = list1;
		}
		if (list2 != null) {
			tail.next = list2;
		}
		return head.next;
	}
}
