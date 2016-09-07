package com.walkerwang.algorithm.swordoffer;

public class Array2FindVal {
	public static void main(String[] args) {
		/**
		 * 1-������ͬ
		 * 				{{1,5,9,13},
						{2,6,10,14},
						{3,7,11,15},
						{4,8,12,16}};
		 * 2-��>��(��>��)
		 * 				{{1,5,9},
						{2,6,10},
						{3,7,11},
						{4,8,12}};
		 */
		int[][] array = {{1,5,9},
				{2,6,10},
				{3,7,11},
				{4,8,12}};
		int target = 10;
		System.out.println(findVal(array, target));
		System.out.println(findVal2(array, target));
		System.out.println(findVal3(array, target));
	}
	
	/**
	 * 1-������⣺ֱ�ӱ�����ά����
	 * ����ʱ�䣺177ms
	          ռ���ڴ棺5074k
	 */
	public static boolean findVal(int[][] array, int target){
		//������array.length
		//������array[0].length
		boolean flag = false;
		for(int i=0; i<array.length; ++i){
			for(int j=0; j<array[0].length; ++j){
				if (array[i][j] == target) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
	
	/**
	 * 2-�����Ͻ���ֵ�Ƚϣ����������չ��
	 * ����ʱ�䣺169ms
		ռ���ڴ棺5148k
	 */
	public static boolean findVal2(int[][] array, int target){
		boolean flag = false;
		int rows = array.length;
		int columns = array[0].length;
		int row = 0;
		int column = columns - 1;
		if(array.length != 0 && rows>0 && columns>0){
			while(row<rows && column>=0){
				if(array[row][column] == target){
					flag = true;
					break;
				}else if(array[row][column] > target){
					--column;
				}else{
					++row;
				}
			}
		}
		return flag;
	}
	
	/**
	 * 3-�����½���ֵ���һ��ϱȽ�
	 */
	public static boolean findVal3(int[][] array, int target){
		boolean flag = false;
		int rows = array.length;
		int columns = array[0].length;
		int row = rows-1;
		int column = 0;
		if(array.length != 0 && rows>0 && columns>0){
			while(row>=0 && column<columns){
				if(array[row][column] == target){
					flag = true;
					break;
				}else if(array[row][column] < target){
					++column;
				}else {
					--row;
				}
			}
		}
		return flag;
	}
}
