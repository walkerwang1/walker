package com.interviewgold.ch2;

import java.util.Stack;

/**
 * 检查链表是否为回文
 * @author walkerwang
 *
 */
public class problem_7 {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		System.out.println(new problem_7().solution02(node1));
	}
	
	/*
	 * 1-反转链表，并比较每个元素是否一样，其实只需要比较一般即可，因为链表是对称的
	 */
	public boolean solution01(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		//反转是在原来的链表上修改的，即原来的链表被破坏了（此方法暂时不行）
		ListUtil.printLinkedList(reverList02(head));
		//反转后的链表
		Node retHead = reverList01(head);
		while(head != null && retHead != null) {
			if (head.data != retHead.data) {
				return false;
			}
			head = head.next;
			retHead = retHead.next;
		}
		return true;
	}
	
	/*
	 * 2-迭代法
	 * 
	 * 链表的前半部分入栈，然后依次将当前结点与栈顶元素比较
	 * 
	 * 链表长度位置（使用“快行指针”，slow和fast）
	 */
	public boolean solution02(Node head) {
		Node slow, fast;
		slow = fast = head;
		Stack<Integer> stack = new Stack<>();
		/* 将链表前半部分入栈。当快速runner（移动速度为慢速runner的两倍）到达链表尾部时，
		 * 则慢速runner已处在链表中间位置 */
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//如果链表个数为奇数，则跳过中间元素
		if (fast != null) {
			slow = slow.next;
		}
		
		while(slow != null) {
			int top = stack.pop();
			//当前结点元素如果与top不相同，则不是回文序列
			if(top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	/*
	 * 3-递归法
	 */
	public boolean solution03(Node node) {
		
		return false;
	}
	
	/*
	 * 反转链表-非递归
	 */
	public Node reverList01(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node cur, tmp;	//tmp临时结点，保存cur结点的指针域，即cur.next
		cur = head.next;
		head.next = null;
		while(cur != null) {
			tmp = cur;
			cur = cur.next;
			
			//头插法
			tmp.next = head;
			head= tmp;
		}
		//最后将原链表的头节点指针域设置为null，返回新链表的头节点，即原链表的尾节点
		return head;
	}
	
	/*
	 * 反转链表-递归
	 * 
	 * 执行到最后尾节点，直接返回head，然后执行倒数第二个节点的reverList02()方法的后面的代码
	 */
	public Node reverList02(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node node = reverList02(head.next);
		head.next.next = head;
		head.next = null;
		return node;
	}
}
