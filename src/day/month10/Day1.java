package day.month10;

public class Day1 {

	public static void main(String[] args) {
		Day1 day1 = new Day1();
		int[] arr = {1,2,7,4,10,11,7,12,6,7,16,18,19};
		day1.findUnsortedSequene(arr);
	}
	
	public void findUnsortedSequene(int[] arr) {
		/*找出左连续子序列*/
		int end_left = 0;
		for(int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i-1]) {
				end_left = i;
			} else {
				break;
			}
		}
		
		/*找出右连续子序列*/
		int start_right = arr.length - 1;
		for(int i = arr.length-2; i >= 0; i--) {
			if (arr[i] < arr[i+1]) {
				start_right = i;
			} else {
				break;
			}
		}
		System.out.println("end_left:" + end_left);
		System.out.println("start_right:" + start_right);
		
		/*找出中间部分的最大值和最小值*/
		int min_index = end_left + 1;
		int max_index = start_right - 1;
		for(int i = min_index+1; i <= start_right-1; i++) {
			if (arr[i] < arr[min_index]) {
				min_index = i;
			}
			if (arr[i] > arr[max_index]) {
				max_index = i;
			}
		}
		System.out.println("min_index:" + min_index);
		System.out.println("max_index:" + max_index);
		
		int left_index = 0;
		/*向左移动，直到小于arr[min_index]*/
		for(int i = end_left; i >= 0; i--) {
			int comp = arr[min_index];
			if (arr[i] >= comp) {
				left_index = i;
			} else {
				break;
			}
		}
		
		int right_index = arr.length - 1;
		/*向右移动，直到大于arr[max_index]*/
		for(int i = start_right; i < arr.length; i++) {
			int comp = arr[max_index];
			if (arr[i] <= comp) {
				right_index = i;
			} else {
				break;
			}
		}
		
		System.out.println(left_index + "," + right_index);
	}
}
