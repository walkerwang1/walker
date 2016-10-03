package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class ListKthToTail {
	public static void main(String[] args) {
		Scanner  scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		ListNode head = new ListNode(0);
		ListNode prev = head;
		while (n >= 1) {
			prev.next = new ListNode(scanner.nextInt());
			prev = prev.next;
			n--;
		}
		int k = scanner.nextInt();
		System.out.println(findKthToTail(head, k));
	}
	
	public static int findKthToTail(ListNode head, int k){
		ListNode pre = head;
		while(k>=0 && pre!=null){
			pre = pre.next;
			k--;
		}
		while(pre != null){
			pre = pre.next;
			head = head.next;
		}
		return head.v;
	}

	private static class ListNode {
		int v;
		ListNode next;

		public ListNode(int v) {
			this.v = v;
		}
	}
}
