package com.walkerwang.datastructure;

/*
 * 排序算法
 * http://www.cricode.com/3212.html
 */
public class SortAlg {
	
	public static void main(String[] args) {
		SortAlg sortAlg = new SortAlg();
		int[] arr = {3,7,2,5,8,4,1,6,9};
		/*1-快速排序
		System.out.println("快速排序:");
		quickSort(arr,0,arr.length-1);
		*/
		
		/*2-归并排序
		System.out.println("归并排序:");
		mergeSort(arr,0,arr.length-1);
		*/
		
		/*3-堆排序

		 */
		
		/*5-希尔排序
		 */
		System.out.println("希尔排序:");
		sortAlg.shellSort(arr);
		
		/*6-插入排序
		System.out.println("插入排序:");
		sortAlg.insertSort(arr);
		 */
		
		/*6-插入排序
		System.out.println("插入排序:");
		sortAlg.insertSort(arr);
		 */
		
		printArray(arr);
	}
	
	/**
	 * 1-快速排序（不稳定）
	 */
	public void quickSort(int[] arr, int left, int right){
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
	public void mergeSort(int[] arr, int left, int right){
		if(left < right){
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge2SortedArr(arr,left,mid,right);	// 合并两个有序的数组
		}
	}
	
	/**
	 * 3-堆排序（稳定）
	 */
	
	/**
	 * 4-冒泡排序（稳定）
	 */
	public void bubbleSort(int[] arr){
		for(int i=1; i<arr.length; i++){	//比较次数
			for(int j=0; j<arr.length-i; j++){ 	//最大的数移动最右边
				if(arr[j] > arr[j+1]){
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	/**
	 *5-希尔排序 
	 	常用的h序列由Knuth提出，该序列从1开始，通过如下公式产生：
		h = 3 * h +1
		反过来程序需要反向计算h序列，应该使用
		h=(h-1)/3
	 */
	public void shellSort(int[] arr) {
		//计算出最大的h值
		int h = 1;
		while(h <= arr.length/3) {
			h = h*3 + 1;
		}
//		h = 1;	//相当于插入排序
		while(h > 0) {
			for(int i=h; i<arr.length; i++) {
				for(int j=i; j>=h; j-=h){
					if(arr[j] < arr[j-h]) {
						swap(arr, j, j-h);
					}
				}
			}
			printArray(arr);
			//计算出下一个h的值
			h = (h-1)/3;
		}
	}
	
	
	/**
	 * 6-插入排序
	 */
	public void insertSort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			for(int j=i; j>=1; j--){
				if(arr[j] < arr[j-1]){
					swap(arr, j, j-1);
				}
			}
		}
	}
	
	
	/**
	 * 7-选择排序
	 */
	
	
	/**
	 * 8-基数排序
	 */
	
	
	/**
	 * 合并两个有序的数组（与连接两个有序的单链表操作类似）
	 * arr[left,mid]和arr[mid+1,right]是两个有序的数组，对其整合排序
	 */
	public void merge2SortedArr(int[] arr, int left, int mid, int right){
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
			arr[left+i] = tmp[i];	//这里的下标要注意
		}
	}
	
	/**
	 * 交换内容，用数组索引
	 */
	public void swap(int[] arr, int index1, int index2){
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
	
	public static void printArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
}
