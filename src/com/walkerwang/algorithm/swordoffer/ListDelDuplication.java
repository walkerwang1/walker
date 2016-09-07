package com.walkerwang.algorithm.swordoffer;

public class ListDelDuplication {
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(1);
		ListNode listNode3 = new ListNode(1);
		ListNode listNode4 = new ListNode(1);
		ListNode listNode5 = new ListNode(1);
		ListNode listNode6 = new ListNode(5);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = null;
		ListPrint.printList(listNode1);
		ListNode retList = deleteDuplication2(listNode1);
		System.out.println();
		ListPrint.printList(retList);
	}
	
	//���ظ�����ֻ��һ���ظ���Ԫ��
	public static ListNode deleteDuplication(ListNode pHead){
		if(pHead == null ){
            return pHead;
        }
        ListNode pre, p;
        pre = pHead;
        p = pHead.next;
        while(pre != null && p != null){
            if(p.val == pre.val){
                //delete(p),then p.next
                p = p.next;
                pre.next = p;
            }else{
                pre = pre.next;
                p = p.next;
            }
        }
		return pHead;
	}
	
	
	//���ظ�����ɾ���ظ�������Ԫ��
	/**
	 * ����ʱ�䣺42ms
		ռ���ڴ棺654k
	 */
	public static ListNode deleteDuplication2(ListNode pHead){
		if (pHead == null) {
			return null;
		}
		ListNode head = new ListNode(0);
		ListNode p = pHead;
		ListNode pre = head;
		head.next = pHead;
//		boolean flag = false;
		while(p != null){
			ListNode q = p.next;
			if (q == null) {
				break;
			}
			if (q.val == p.val) {
				while(q != null && q.val == p.val){
					q = q.next;
				}
				pre.next = q;
				p = q;
			}else{
//				if (!flag) {
//					head.next = p;
//					flag = true;
//				}
				pre = p;
				p = q;
			}
		}
		return head.next;
	}
}
