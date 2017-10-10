package day.month9;

public class Day7 {

	public static void main(String[] args) {
		Day7 day7 = new Day7();
		int[] arr = {1,3,5,10,14,20};  //0-6
		int x = 14;
		
		System.out.println(day7.binarySearch(arr, x));
	}
	
	/*
	 * 二分查找
	 * 	若存在，则返回值在arr中的下标；
	 * 	若不存在，则返回-1。
	 */
	public int binarySearch(int[] arr, int x) {
		int left = 0;
		int right = arr.length - 1;
		int mid = -1;
		while(left <= right) {
			mid = left + (right - left) / 2;
			if (arr[mid] == x) {
				return mid;
			} else if(arr[mid] < x) {
				left = mid + 1;
			} else if(arr[mid] > x) {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	/*
	 * 有一组数字，其中有正负数，有整数和浮点数，排序的要求是首先正数排在负数前，
	 * 然后整数排在浮点数前，然后再按绝对值由小到大排序
	 * [-13, 14, 5, 5, 18, -2, 13, 15, -3, 10, 9.43, -4.43, 
	 * 		4.57, 8.57, 9.57, -6.14, 2.29, 9.43, 4.14, -5.57]
	 */
	public void sortNum(Object[] arr) {
		
	}
}
