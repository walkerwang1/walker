package com.interviewgold.ch2;

/*
 * 找出单向链表中倒数第k个节点
 */
public class problem_2 {

	public static void main(String[] args) {
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node5 = new Node<>(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		problem_2 problem_2 = new problem_2();
		System.out.println(problem_2.solution01(node1, 0));
	}

	/*
	 * 1-快行指针
	 */
	public int solution01(Node<Integer> node, int k) {
		if (node == null || k < 0) {
			return -1;
		}
		Node slow = node;
		Node fast = slow;
		while (--k > 0) {
			if (fast.next == null) {	  //k位置非法	
				return -1;
			}
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return (int) slow.item;
	}
}
