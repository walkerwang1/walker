package com.algs4;

import java.util.Stack;

public class test {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop() + stack.pop() + stack.pop()); // 3 2 1
		
		Iterable<Integer> iter = stack;
		for(int x : iter) {
			System.out.println(x);		//1 2 3
		}
	}
}
