package day.month9;

public class Day3 {
	
	public static void main(String[] args) {
		Day3 day3 = new Day3();
		int[] arr = {1,2,3,1,1};
//		day3.moreThanHalfNum(arr);
		
		String MaxStr = "21474836471";
		String string = "20474836471";
		System.out.println(string.compareTo(MaxStr));
	}
	
	/*
	 * 1-找出数组中出现次数超过一半的数
	 */
	public void moreThanHalfNum(int[] arr) {
		
		if (arr.length <= 0) {
			return;
		}
		
		int length = arr.length;
		int middle = length >> 1;
		int left = 0;
		int right = length -1;
		int index = partition(arr,left, right);
		while(index != middle) {
			if (index > middle) {
				index = partition(arr, left, index-1);
			}else {
				index = partition(arr, index+1, right);
			}
		}
		int result = arr[middle];
		
		if (!checkMoreThanHalf(arr, result)) {
			result = -1;
		}
		
		System.out.println(result);
	}
	
	/*
	 * 1-以arr[left]为基准随机快速排序
	 * 返回arr[left]在arr中一次快排后的下标
	 */
	public int partition(int[] arr, int left, int right) {
		int tmp = arr[left];
		int i = left;
		int j = right;
		while(i != j) {
			while(i < j && arr[j] >= tmp)
				j--;
			while(i < j && arr[i] <= tmp)
				i++;
			if (i < j) {
				int v = arr[i];
				arr[i] = arr[j];
				arr[j] = v;
			}
		}
		arr[left] = arr[i];
		arr[i] = tmp;
		return i;
	}
	
	/*
	 * 1-判断数字result是否超过一半
	 */
	public boolean checkMoreThanHalf(int[] arr, int result) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == result) {
				count++;
			}
		}
		if (count * 2 > arr.length) {
			return true;
		}
		return false;
	}
}
