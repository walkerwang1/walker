package day.month9;

import java.util.TreeSet;

/*
 * 寻找数组中最小的k个数:4中方法。
 * （1）快排；（2）新数组索引；（3）部分快排；（4）长度为k的数组，红黑树
 */
public class Day12 {
	
	public static void main(String[] args) {
		Day12 day12 = new Day12();
		int[] arr = {4,5,1,3,2,7,3,8};
		int k = 4;
		/*day12.quicksort(arr, 0, arr.length-1);
		
		for(int i = 0; i < k; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();*/
		
//		day12.arrIndex(arr);
		
		day12.onePrtition(arr);
		
//		day12.defineArr(arr, k);
	}

	/*
	 * 寻找数组中最小的k个数——快速排序：时间复杂度nlog(n)
	 */
	public void quicksort(int[] arr, int left, int right) {
		if (left > right) {		//递归出口
			return;
		}
		int tmp = arr[left];
		int i = left; 
		int j = right;
		while(i != j) {
			while(i < j && tmp <= arr[j])
				j--;
			while(i < j && tmp >= arr[i])
				i++;
			if (i < j) {
				int a = arr[i];
				arr[i] = arr[j];
				arr[j] = a;
			}
		}
		arr[left] = arr[i];
		arr[i] = tmp;
		
		quicksort(arr, left, i-1);	//确定了中间数后向两边扩展
		quicksort(arr, i+1, right);
	}
	
	/*
	 * 寻找数组中最小的k个数——数组，把数组的值当作坐标
	 * （假设比较强，如果数组中存在重复的数字，则newarr会覆盖，有问题）。
	 */
	public void arrIndex(int[] arr) {
		int max_value = Integer.MIN_VALUE;
		//确定数组最大的长度
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] > max_value) {
				max_value = arr[i];
			}
		}
		int[] newarr = new int[max_value+1];
		for(int i = 0; i < arr.length; i++) {
			newarr[arr[i]]  = arr[i];
		}
		int cnt = 1; 
		int k = 4;
		for(int i = 0; i < newarr.length; i++) {
			if (newarr[i] != 0) {
				System.out.print(newarr[i] + " ");
				cnt++;
				if (cnt > 4) {
					break;
				}
			}
		}
	}
	
	/*
	 * 寻找数组中最小的k个数——部分快排。（这种方式求得的k个数不一定能够是有序的）
	 * 			发现基准数的index=k-1时，此时，基准数左半部分的数就是最小的k个数
	 */
	public void onePrtition(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		int k = 4;
		int index = partition(arr, 0, arr.length-1);
		int left = 0;
		int right =arr.length-1;
		//寻找基准数
		while(index != k-1) {
			if (index > k-1) {
				index = partition(arr, left, index-1);
			}else {
				index = partition(arr, index+1, right);
			}
		}
		
		if (index == k-1) {
			for(int i = 0; i <= index; i++) {
				System.out.print(arr[i] + " ");
			}
		}
		
	}
	
	//一次快排
	public int partition(int[] arr, int left, int right) {
		if (left > right) {
			return -1;
		}
		int tmp = arr[left];
		int i = left;
		int j = right;
		while(i != j) {
			while(i < j && tmp <= arr[j]) {
				j--;
			}
			while(i < j && tmp >= arr[i]) {
				i++;
			}
			if (i < j) {
				int a = arr[i];
				arr[i] = arr[j];
				arr[j] = a;
			}
		}
		arr[left] = arr[i];
		arr[i] = tmp;
		return i;
	}
	
	/*
	 * 寻找数组中最小的k个数——定义长度为k的数组，进行比较替换。红黑树
	 * 		红黑树不能保证数组中若存在有序的情况
	 */
	public void defineArr(int[] arr, int k) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		for(int i = 0; i < arr.length; i++) {
			if (treeSet.size() < k) {		//保证treeset的长度不超过k
				treeSet.add(arr[i]);
			} else {
				int a = treeSet.last();
				if (arr[i] < a) {
					treeSet.remove(a);
					treeSet.add(arr[i]);
				}
			}
		}
		System.out.println(treeSet);
	}
}
