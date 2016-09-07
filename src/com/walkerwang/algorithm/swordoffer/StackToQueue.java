package com.walkerwang.algorithm.swordoffer;

import java.util.Stack;

public class StackToQueue {
	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>(); 
	
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		stack2.push(4);
		stack2.push(5);
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
	}	
	
	/**
	 * ����ʱ�䣺30ms
		ռ���ڴ棺629k
	 *stack1:��Ϊ��ӵ�ջ
	 *stack2:��Ϊ���ӵ�ջ
	 */
	//���
	public static void push(int node){
		stack1.push(node);
	}
	
	//����
	public static int pop(){
		//stack2Ϊ�գ���stack1�е�Ԫ��ȫ������stack2��
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}else{
			//ֱ�ӳ�ջstack2�е�Ԫ��
			return stack2.pop();
		}
		return stack2.pop();
	}
}
