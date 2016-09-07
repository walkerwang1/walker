package com.walkerwang.algorithm.swordoffer;

import java.util.Stack;

public class StackMin {
	public static Stack<Integer> m_data = new Stack<>(); // ����ջ
	public static Stack<Integer> m_min = new Stack<>(); // ����ջ

	public static void main(String[] args) {
		push(3);
		push(4);
		push(2);
		push(1);
		pop();
		pop();
		push(0);
		System.out.println(min());
		System.out.println(pop()+""+pop());
	}

	/**
	 * ����ʱ�䣺30ms
		ռ���ڴ棺629k
	 */
	public static void push(int node) {
		if (m_data.isEmpty()) {
			m_min.push(node);
			m_data.push(node);
		} else {
			if (m_data.peek() < node) {
				m_min.push(m_data.peek());
				m_data.push(node);
			} else {
				m_min.push(node);
				m_data.push(node);
			}
		}
	}

	public static int pop() {
		m_min.pop();
		return m_data.pop();
	}
	
	public static int top(){
		return m_data.peek();
	}

	// ȡջ����СԪ��
	public static int min() {
		return m_min.peek();
	}
}