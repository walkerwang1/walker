package com.walkerwang.algorithm.swordoffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
	static Queue<Integer> deque1 = new LinkedList<>();
	static Deque<Integer> deque2 = new LinkedList<>();
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
	}
	
	//��ջ
	public static void push(int node){
		deque1.add(node);
	}
	
	//��ջ
	public static int pop(){
		return deque1.poll();
	}
	
}
