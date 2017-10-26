package day.month10;

public class Day7 {

	public static void main(String[] args) {
		Day7 day7 = new Day7();
		int[] arr = {2,3,1,0,2,5,3};
		day7.secondNum(arr);
	}
	
	/*
	 * 数组中第一次出现重复的元素
	 */
	public void secondNum(int[] arr) {
		String str = "";
		for(int i = 0; i < arr.length; i++) {
			if (str.indexOf(arr[i] + "") >= 0) {
				System.out.println(arr[i]);
				break;
			}
			str += arr[i];
		}
	}
}
