package com.algs4;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.print.attribute.standard.NumberUp;


public class Queue<Item> implements Iterable<Item> {

	private Node<Item> first;	//链表头指针
	private Node<Item> last;	//链表尾指针
	private int n;			//链表元素个数
	
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}
	
	public Queue() {
		first = null;
		last  = null;
		n = 0;
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * 队列长度
	 * @return
	 */
	public int size() {
		return n;
	}
	
	/**
	 * 取队头元素的值（元素不移除队列）
	 * @return
	 */
	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}
		return first.item;
	}
	
	/**
	 * 元素入队（链表头first，链表尾last，元素入队从链表尾部插入）
	 * @param item
	 */
	public void enqueue(Item item) {
		Node<Item> oldlast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}
		n++;
	}
	
	/**
	 * 元素出队
	 * @return
	 */
	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}
		Item item =first.item;
		first = first.next;
		n--;
		if (isEmpty()) {
			last = null;
		}
		return item;
	}
	
	/**
	 * 返回队列的字符串表示
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Item item : this) {
			sb.append(item);
			sb.append(' ');
		}
		return sb.toString();
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}
	
	// 迭代器
	private class ListIterator<Item> implements Iterator<Item> {

		private Node<Item> current;
		
		public ListIterator(Node<Item> first) {
			current =first;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public void remove() { 
			throw new UnsupportedOperationException();  
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	public static void main(String[] args) {
		Queue<String> queue = new Queue<>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				queue.enqueue(item);
			} else if (!queue.isEmpty()) {
				StdOut.print(queue.dequeue() + " ");
			}
		}
		StdOut.println("(" + queue.size() + " left on queue)");
	}

}
