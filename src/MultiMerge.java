
public class MultiMerge {
	public static void main(String[] args) {
		MultiMerge merge = new MultiMerge();
		
		int[] arr = {};
//		merge.mergeSort(arr, 0, arr.length-1);
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		
	}

	public void mergeSort(int[] arr, int left, int right){
		if(left < right){
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge2SortedArr(arr,left,mid,right);	// 合并两个有序的数组
		}
	}
	
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
		
		//将tmp中的值全部赋值到arr中
		for(i=0;i<k; i++){
			arr[left+i] = tmp[i];	//这里的下标要注意：left+i
		}
	}
}
