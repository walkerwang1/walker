package com.interviewgold.ch2;

/*
 * 链表节点定义
 */
public class Node {
	 int data;
     Node next;
     Node prev;

     Node(Node prev, int element, Node next) {
         this.data = element;
         this.next = next;
         this.prev = prev;
     }
     
     /*
      * 这个只是方便《面试经典》程序用，上面那个是仿照JDK的LinkedList写的
      */
     Node(int element) {
    	 this.data = element;
     }
}
