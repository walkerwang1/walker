package com.interviewgold.ch2;

/*
 * 链表节点定义
 */
public class Node<E> {
	 E item;
     Node<E> next;
     Node<E> prev;

     Node(Node<E> prev, E element, Node<E> next) {
         this.item = element;
         this.next = next;
         this.prev = prev;
     }
     
     /*
      * 这个只是方便《面试经典》程序用，上面那个是仿照JDK的LinkedList写的
      */
     Node(E element) {
    	 this.item = element;
     }
}
