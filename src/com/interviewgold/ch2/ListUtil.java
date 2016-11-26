package com.interviewgold.ch2;


public class ListUtil {
	
	public static void printLinkedList(Node node) {
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Node node1 = new Node(null, 1, null);
		Node node2 = new Node(null, 2, null);
		Node node3 = new Node(null, 3, null);
		Node node4 = new Node(null, 4, null);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
	}
}
