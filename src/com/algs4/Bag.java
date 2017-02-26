package com.algs4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
	private Node<Item> first;	//begining of bag
	private int n;				//number of elements in bag
	
	//helper linked list class
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}
	
	/**
	 * Initialalizes an empty bag.
	 */
	public Bag() {
		first = null;
		n  =0;
	}
	
	/**
	 * Returns true if this bag is empty.
	 * 
	 * @return  {@code ture} if this bag is empty;
	 * 			{@code false} otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * Returns the number of items in this bag
	 * 
	 * @return the number of items in this bag
	 */
	public int size() {
		return n;
	}
	
	/**
	 * Adds the item to this bag.
	 * 链表的头插法
	 * 
	 * @param item
	 * 			the item to add to this bag.
	 */
	public void add(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		n++;
	}
	
	/**
	 * Returns an iterator that iterates over the items in this bag in arbitrary order.
	 * 
	 * @return
	 * 		an iterator that iterates over the items in this bag in arbitrary order
	 */
	public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }
	
	//and iterator, doesn't implement remove()
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;
		
		public ListIterator(Node<Item> first) {
			current = first;
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
	
	/**
	 * Unit tests the {@code Bag} data type.
	 * 
	 * @param args
	 * 			the command-line arguments
	 */
	public static void main(String[] args) {
		Bag<String> bag = new Bag<String>();
		while(!StdIn.isEmpty()) {			//按"Ctrl + Z",scanner.hasNext()返回flase
			String item = StdIn.readString();
			bag.add(item);
		}
		StdOut.println("size of bag = " + bag.size());
		for (String s : bag) {
			StdOut.println(s);
		}
		
//		Iterator<String> iter = bag.iterator();
//		while(iter.hasNext()) {
//			String s = iter.next();
//			StdOut.println(s);
//		}
	}
}
