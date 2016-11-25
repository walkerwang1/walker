package com.interviewgold.ch1;

/*
 * N*N数组旋转
 */
public class problem_6 {

	public static void main(String[] args) {
		int[][] martix = {{1,2,3},{4,5,6},{7,8,9}};
		printMartix(martix);
		new problem_6().rotate01(martix);
		System.out.println("转换后的结果：");
		printMartix(martix);
	}
	
	
	/*
	 * 1-记录某一行的某一个数据，然后旋转每个元素
	 */
	public int[][] rotate01(int[][] martix) {
		int n = martix.length;	//行数
		for(int layer=0; layer<n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i=first; i<last; i++) {
				int offset = i - first;		//偏移量的定义
				
				//存储上边第一个数
				int top = martix[first][i];
				
				//左-->上
				martix[first][i] = martix[last-offset][first];
				
				//下-->左
				martix[last-offset][first] = martix[last][last-offset];
				
				//右-->下
				martix[last][last-offset] = martix[i][last];
				
				//上-->右
				martix[i][last] = top;
			}
		}
		return martix;
	}
	
	public static void printMartix(int[][] martix) {
		for(int i=0; i<martix.length; i++) {
			for(int j=0; j<martix[0].length; j++) {
				System.out.print(martix[i][j]);
			}
			System.out.println();
		}
	}
}
