package com.walkerwang.datastructure;

public class SortAlg {
	
	public static void main(String[] args) {
		int[] arr = {3,7,2,5,8,4,1,6,9};
		//1-快速排序
//		quickSort(arr,0,arr.length-1);
		//2-归并排序
		mergeSort(arr,0,arr.length-1);
		//3-堆排序
		
		//4-冒泡排序
//		bubbleSort(arr);
		printArray(arr);
	}
	
	/**
	 * 1-快速排序（不稳定）
	 */
	public static void quickSort(int[] arr, int left, int right){
		if(left >=right)
			return;
		int tmp = arr[left];
		int i,j;
		i = left;
		j = right;
		while(i != j){
			//这两个while循环顺序不能颠倒，要先从j开始遍历
			while(i<j && arr[j]>=tmp){
				j--;
			}
			while(i<j && arr[i]<=tmp){
				i++;
			}
			if(i < j){
				int t;
				t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		//基准a[left]归位（其实就是a[left]和a[i]交换）
		arr[left] = arr[i];
		arr[i] = tmp;
		
		quickSort(arr, left, i-1);
		quickSort(arr, i+1, right);
	}
	
	/**
	 * 2-归并/合并排序（稳定）
	 */
	public static void mergeSort(int[] arr, int left, int right){
		if(left < right){
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge2SortedArr(arr,left,mid,right);
		}
	}
	
	/**
	 * 3-堆排序（稳定）
	 */
	
	/**
	 * 4-冒泡排序（稳定）
	 */
	public static void bubbleSort(int[] arr){
		for(int i=1; i<arr.length; i++){	//比较次数
			for(int j=0; j<arr.length-i; j++){ 	//最大的数移动最右边
				if(arr[j] > arr[j+1]){
//					swap(arr[j], arr[j+1]);	//值传递,
					int tmp;
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
	/**
	 *5-希尔排序 
	 */
	
	
	/**
	 * 合并两个有序的数组（与连接两个有序的单链表操作类似）
	 * arr[left,mid]和arr[mid+1,right]是两个有序的数组，对其整合排序
	 */
	public static void merge2SortedArr(int[] arr, int left, int mid, int right){
		int[] tmp = new int[right+1];
		int i=left, j=mid+1;
		int m=mid, n=right;
		int k =0;
		while(i<=m && j<=n){
			if(arr[i] < arr[j]){
				tmp[k++] = arr[i++];
			}else{
				tmp[k++] = arr[j++];
			}
		}
		while(i<=m){
			tmp[k++] = arr[i++];
		}
		while(j <= n){
			tmp[k++] = arr[j++];
		}
		for(i=0;i<k; i++){
			arr[left+i] = tmp[i];
		}
	}
	
	/**
	 * 交换值，原来的值并没有交换
	 */
	public static <T> void swap(T a, T b){
		T tmp;
		tmp = a;
		a = b;
		b = tmp;
	}
	
	public static void printArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
}
