package day;

/*
 * 合并两个有序数组
 */
public class Day1 {
	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7,9};
		int[] arr2 = {2,4,6,8,10};
		
		Day1 obj = new Day1();
		
		obj.mergeArray(arr1, arr2);
		
		obj.defineList();
		
	}
	
	/*
	 * 合并两个有序数组
	 */
	public void mergeArray(int[] arr1, int[] arr2) {
		
		int[] res = new int[arr1.length + arr2.length];		//定义一个能容纳两个数组元素的数组
		
		int i = 0, j = 0;
		int k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				res[k++] = arr1[i++];
			} else {
				res[k++] = arr2[j++];
			}
		}
		
		while(i < arr1.length) {   //arr1有剩余元素
			res[k++] = arr1[i++];
		}
		
		while(j < arr2.length) {	//arr2有剩余元素
			res[k++] = arr2[j++];
		}
	
		for(int m = 0; m < res.length; m++) {
			System.out.print(res[m] + " ");
		}
	}
	
	
	/*
	 * 合并两个有序链表
	 */
	public ListNode mergeList(ListNode list1, ListNode list2) {
		
		if (list1 == null && list2 == null)
			return null;
		if (list1 == null)
			return list2;
		if (list2 == null) {
			return list1;
		}
		
		ListNode head = new ListNode(-1);
		ListNode tail = head;
		while (list1 != null && list2 != null) {
			if (list1.val >= list2.val) {
				tail.next = list2;
				tail = tail.next;
				list2 = list2.next;
			} else {
				tail.next = list1;
				tail = tail.next;
				list1 = list1.next;
			}
		}

		if (list1 != null) {
			tail.next = list1;
		}
		if (list2 != null) {
			tail.next = list2;
		}
		
		ListNode p = head.next;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		
		return head.next;
	}
	
	void defineList() {
		ListNode ListNode11 = new ListNode(1);
		ListNode ListNode12 = new ListNode(3);
		ListNode ListNode13 = new ListNode(5);
		ListNode11.next = ListNode12;
		ListNode12.next = ListNode13;
		ListNode13.next = null;
		
		ListNode ListNode21 = new ListNode(2);
		ListNode ListNode22 = new ListNode(4);
		ListNode ListNode23 = new ListNode(6);
		ListNode21.next = ListNode22;
		ListNode22.next = ListNode23;
		ListNode23.next = null;
		
		mergeList(ListNode11, ListNode21);
	}
	
	class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int data) {
			this.val = data;
		}
	}
	
}
