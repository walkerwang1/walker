package com.interviewgold.ch2;


/**
 * 以定值x为基准，将链表分割成两部分，所有小于x的结点排在大于等于x的结点之前
 * @author walkerwang
 *
 */
public class problem_4 {

	public static void main(String[] args) {
		Node<Integer> node1 = new Node<>(5);
		Node<Integer> node2 = new Node<>(4);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(2);
		Node<Integer> node5 = new Node<>(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ImplLinkedList.printLinkedList(node1);
		int x = 3;
		Node ret = new problem_4().solution02(node1, x);
		ImplLinkedList.printLinkedList(ret);
		
	}
	
	/*
	 * 1-直接创建两个链表，一个存放小于x的元素，另一个链表存放大于或等于x的元素
	 */
	public Node<Integer> solution01(Node<Integer> node, int x) {
		Node<Integer> beforeStart = null;
		Node<Integer> beforeEnd = null;
		Node<Integer> afterStart = null;
		Node<Integer> afterEnd = null;
		
		/* 分割链表 */
		while(node != null) {
			Node<Integer> next = node.next;
			node.next = null;	//分割节点的指针域置null
			if (node.item < x ) {
				/* 将结点插入before链表 */
				if(beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {	//node.item >= x
				/* 将结点插入after链表 */
				if(afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		
		if (beforeStart == null) {
			return afterEnd;
		}
		/* 合并before和after链表 */
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	
	/*
	 * 2-结点不再追加至before和after链表的末端（尾插法），而是插入到这两个链表的前端（头插法）
	 */
	public Node<Integer> solution02(Node<Integer> node, int x) {
		Node<Integer> beforeStart = null;
		Node<Integer> afterStart = null;
		/* 分割链表 */
		while(node != null) {
			Node<Integer> next = node.next;
			node.next = null;
			if(node.item < x) {
				/* 将结点插入before链表的前端  */
				node.next = beforeStart;
				beforeStart = node;
			} else {
				/* 将结点插入after链表的前端  */
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}
		
		/* 合并before和after链表  */
		if(beforeStart == null ) {
			return afterStart;
		}
		
		/* 定位至before链表末尾，合并两个链表 */
		Node<Integer> head = beforeStart;
		while(beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;
		return head;
	}
}
