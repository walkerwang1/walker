package com.walkerwang.algorithm.swordoffer;

public class ListLoop {

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
		listNode5.next = listNode2;

		ListNode listNode = EntryNodeOfLoop(listNode1);
		System.out.println(listNode.val);
	}

	/**
	 * ����ʱ�䣺43ms ռ���ڴ棺654k
	 */
	public static ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		ListNode slow, fast;
		slow = fast = pHead;
		while (slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next.next;
			// �������غϵ�ֱ�ʼ�������ĵ���ǻ�����ڽڵ�
			if (slow == fast) {
				ListNode p = pHead;
				while (p != slow) {
					p = p.next;
					slow = slow.next;
				}
				if (p == slow) {
					return p;
				}
			}
		}
		return null;
	}
}
