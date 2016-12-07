package com.walkerwang.list;

import java.util.LinkedList;

public class ImplLinkedList {

	public static void main(String[] args) {
		LinkedList<Object> linkedList = new LinkedList<>();
		
		linkedList.add(2);
		linkedList.size();
	}
	
	@SuppressWarnings("unused")
	private static class Node<E> {
		E item;
		Node<E> prev;
		Node<E> next;
		
		public Node(Node<E> prev, E element, Node<E> next) {
			this.prev = prev;
			this.item = element;
			this.next = next;
		}
	}
}
