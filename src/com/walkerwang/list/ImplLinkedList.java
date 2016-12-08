package com.walkerwang.list;

import java.util.LinkedList;

/**
 * 实现LinkedList源码
 * @author walkerwang
 *
 */
public class ImplLinkedList {

	/*
	 * 1-分析LinkedList结构
	 * 底层结构：双向链表
	 * 
	 * 方法：
	 * 常用方法：add(),get(),set(),size(),remove(),peek(),poll(),node(index),
	 * 栈和队列：peek(),poll(),element(),offer(),push(),pop(),
	 * 双端队列：offerFirst(),offerLast(),peekFirst(),peekLast(),pollFirst(),pollLast()
	 * 迭代器：ListItr
	 */
	
	public static void main(String[] args) {
		LinkedList<Object> stack = new LinkedList<>();
		LinkedList<Object> queue = new LinkedList<>();
		LinkedList<Object> deque = new LinkedList<>();
		
		stack.push(1);stack.push(11);stack.push(111);
//		System.out.println(stack.poll());
		System.out.println(stack.peek());
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
