package com.walkerwang.algorithm.swordoffer;

public class ListFindK {
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
		
//		int len = getSize(listNode1);
		
		int k = 6;
//		if (k <= len) {
//			ListNode p = findKthToTail(listNode1, k);
//			System.out.println(p.val);
//		}else{
//			System.out.println("out of size");
//		}
		ListNode p = findKthToTail(listNode1, k);
		System.out.println(p.val);
	}
	
	public static ListNode findKthToTail(ListNode head, int k){
		if (head == null || k <= 0) {
			return null;
		}
		ListNode p, q;
		p = q = head;
		for(int i=1; i<k; ++i){
			q = q.next;
		}
		//���q==null��˵��p��q֮��Ľڵ�С��k����kֵԽ��
		if(q == null) 
			return null;
		while(q.next != null){
			q = q.next;
			p = p.next;
		}
		return p;
	}
	
	//��ȡ����ĳ���
	public static int getSize(ListNode head){
		int len = 0;
		while(head!= null){
			len++;
			head = head.next;
		}
		return len;
	}
}
