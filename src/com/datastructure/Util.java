package com.datastructure;

public class Util {
	
	public static void printList(ListNode head) {
		if(head == null) {
			return;
		}
		ListNode p = head;
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
	
	public static void gc2() {
		
	}
}
