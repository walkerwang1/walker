package com.interviewgold.ch2;

/**
 * 给定一个有环链表，实现一个算法返回环路的开头结点
 * @author walkerwang
 *
 */
public class problem_6 {

	
	/*
	 * 1-
	 */
	public Node solution01(Node head) {
		Node slow, fast;
		slow = fast = head;
		
		//找出碰撞处，将处于链表中LOOP_SIZE-k步的位置
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {		//碰撞
				break;
			}
		}
		
		//错误检查，没有碰撞处，也即没有环路
		if (fast == null || fast.next == null) {
			return null;
		}
		
		/* 将slow指向首部，fast指向碰撞处，两者距离环路起始处k步，若两者以相同速度移动，
		 * 这必定会在环路起始处碰在一起
		 */
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		// 至此两者均指向环路起始处
		return fast;
	}
}
