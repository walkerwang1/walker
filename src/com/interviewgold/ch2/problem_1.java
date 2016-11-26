package com.interviewgold.ch2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 移除未排序链表中的重复节点
 */
public class problem_1 {
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(2);
		Node node4 = new Node(3);
		Node node5 = new Node(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		problem_1 p = new problem_1();
		p.printList(node1);
		p.printList(p.solution01(node1));
		String string;
		Arrays.sort("wang".toCharArray());
	}
	
	/*
	 * 1-边遍历链表边使用一个HashMap记录每个节点出现的次数，如果没出现则继续遍历，出现则删除该节点
	 */
	public Node solution01(Node node) {
		if(node == null || node.next == null) {
			return node;
		}
		Node pre = node;	//记录当前节点的前驱节点
		Node cur = node.next;	//记录当前节点
		Map<Integer, Integer> map = new HashMap<>();
		map.put(pre.data, 1);	//因为是cur是从第二个节点开始的，so先记录第一个节点的次数
		while(cur != null) {
			if(map.get(cur.data) == null) {	//该节点第一次出现，继续遍历
				pre = cur;
				map.put(cur.data, 1);
				cur = cur.next;
			} else {	//该节点重复，需删除
				cur = cur.next;
				pre.next = cur;
			}
		}
		return node;
	}
	
	

	public void printList(Node node) {
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
}
