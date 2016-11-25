package com.interviewgold.ch2;


public class ImplLinkedList {
	
	public static void printLinkedList(Node node) {
		while(node != null) {
			System.out.print(node.item + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(null, 1, null);
		Node<Integer> node2 = new Node<Integer>(null, 2, null);
		Node<Integer> node3 = new Node<Integer>(null, 3, null);
		Node<Integer> node4 = new Node<Integer>(null, 4, null);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		new ImplLinkedList().printLinkedList(node1);
	}
}
