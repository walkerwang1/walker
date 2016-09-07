package com.walkerwang.algorithm.swordoffer;

import java.util.Stack;

public class PopOrder {
	public static void main(String[] args) {
		int[] pushA = {1,2,3,4,5};
		int[] popA = {4,5,3,2,1};
		/**{1,2,3,4,5};
		 * {4,5,3,2,1};
		 */
		System.out.println(IsPopOrder(pushA, popA));
	}
	
	/**
	 * ����ʱ�䣺27ms
		ռ���ڴ棺629k
	 */
	public static boolean IsPopOrder(int[] pushA, int[] popA){
		if(pushA.length==0 || popA.length == 0){
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int j=0;
		for(int i=0; i<pushA.length; i++){
			stack.push(pushA[i]);
			while(j<popA.length && stack.peek()==popA[j]){
				stack.pop();
				j++;
			}
		}
		if(stack.isEmpty())
			return true;
		return false;
	}
}
