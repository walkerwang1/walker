package com.walkerwang.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

class ListNode{
	int val;
	ListNode next = null;
	
	public ListNode(int val) {
		this.val = val;
	}
}
public class ListPrint {
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = null;
		ArrayList<Integer> list = printListFromTailToHead(listNode1);
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()){
			int x = iter.next();
			System.out.print(x+" ");
		}
		System.out.println();
		printList(listNode1);
	}
	
	//������β��ͷ�������
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		ArrayList<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		if(listNode == null || listNode.next == null){
			return null;
		}
		while(listNode != null){
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while(!stack.isEmpty()){
			list.add(stack.pop());
		}
		return list;
	}
	
	//��ͷ��β�������
	public static void printList(ListNode head){
		if (head == null) {
			return;
		}
		while(head != null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
}
