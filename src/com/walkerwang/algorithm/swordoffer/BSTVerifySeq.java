package com.walkerwang.algorithm.swordoffer;

public class BSTVerifySeq {
	public static void main(String[] args) {
		int[] sequence = {1,7,3,5};
		System.out.println(VerifySquenceOfBST(sequence));
	}
	
	/*
	 * ����ʱ�䣺33ms
		ռ���ڴ棺528k
	 */
	public static boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence.length == 0)
			return false;
		return IsTreeBST(sequence,0,sequence.length-1);
	}
	
	public static boolean IsTreeBST(int[] sequence, int start, int end){
		if(end <= start)
			return true;
		int i=start;
		for(; i<end; i++){	//����0~i֮���С��sequence[end]����
			if(sequence[i] > sequence[end])
				break;
		}
		int j=i;	//����i~end������Ƿ����sequence[end]
		for(; j<end; j++){
			if (sequence[j] < sequence[end]) {
				return false;
			}
		}
		boolean left = true;
		if (i > 0) {
			left = IsTreeBST(sequence, start, i-1);
		}
		boolean right = true;
		if (j < end) {
			right = IsTreeBST(sequence, i, end-1);
		}
		return left && right;
	}
}
