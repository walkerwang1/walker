package day.month10;

public class Day6 {
	
	public static void main(String[] args) {
		Day6 day6 = new Day6();
		int[][] matrix = {{0,-2,-7,0},
						  {9,2,-6,2},
						  {-4,1,-4,1},
						  {-1,8,0,-2}};
		int res = day6.maxSumOfMatrix(matrix);
		System.out.println(res);
	}
	
	/*
	 * 动态规划——最大子矩阵和
	 */
	public int maxSumOfMatrix(int[][] matrix) {
		int maxSum = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		for(int i = 0; i < row; i++) {
			int[] arr = new int[col];
			for(int j = i; j < row; j++) {
				
				for(int k = 0; k < col; k++) {
					arr[k] += matrix[j][k];
				}
				//分别计算(0,0),(0,1),(0,2),……,(0,row)不同列组合的值
				//arr则是多行数据的列的和组成的一维数组，则问题转换成了一维动态规划问题。
				int rowCurSum = maxSumOfArray(arr);
				if (rowCurSum > maxSum) {
					maxSum = rowCurSum;
				}
			}
		}
		return maxSum;
	}
	
	/*
	 * 一维数组的和最大的子序列
	 */
	public int maxSumOfArray(int[] arr) {
		int curSum = 0;
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			curSum += arr[i];
			if (curSum < arr[i]) {
				curSum = arr[i];
			}
			if (curSum > max) {
				max = curSum;
			}
		}
		return max;
	}
}
