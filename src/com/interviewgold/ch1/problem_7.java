package com.interviewgold.ch1;

/*
 * M*N的矩阵中元素为0所在的行和列的值都设置为0
 */
public class problem_7 {
	public static void main(String[] args) {
		int[][] martix = {{1,1,1,1}, {2,2,2,2},{3,3,3,3}};
		int[][] ret = new problem_7().solution01(martix);
		for(int i=0; i<ret.length; i++){
			for(int j=0; j<ret[0].length; j++) {
				System.out.print(ret[i][j]);
			}
			System.out.println();
		}
	}
	
	/*
	 *1-将元素所在的行和列标记为true 
	 */
	public int[][] solution01(int[][] martix) {
		boolean[] row = new boolean[martix.length];	//行数组
		boolean[] column = new boolean[martix[0].length]; //列数组
		for(int i=0; i<martix.length; i++) {
			for(int j=0; j<martix[0].length; j++) {
				if(martix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		//对标记为true的行和列元素设置为0
		for(int i=0; i<martix.length; i++) {
			for(int j=0; j<martix[0].length; j++) {
				if(row[i] || column[j]) {
					martix[i][j] = 0;
				}
			}
		}
		return martix;
	}
	
}
