package day;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day9 {

	public static void main(String[] args) {

        int[] arr = {5,1,2};
        int n = arr.length;
		Arrays.sort(arr);//必须先排序
		int maxValue = 0;
		for(int i = 0; i < arr.length; i++) {	//记录最大的值
			maxValue += arr[i];
		}
		int a;
		for(a = 1; a <= maxValue; a++) {
			ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
	        boolean[] visited = new boolean[n];
	        int sum = a;
			backTrack(arr, visited, 0, 0, sum, lists);	//求和为sum的所有组合数
			System.out.println(a + ":" + lists);
			if (lists.size() == 0) {
				System.out.println(a);
//				break;
			}
		}
    }
    
	/*
	 * 采用回朔法-递归
	 * 每次只需要改变数值“向前一步”，然后后退。
	 */
    public static void backTrack(int[] arr, boolean[] visited, int n, 
            int currSum, int sum, ArrayList<ArrayList<Integer>> lists){
        if(currSum > sum)
            return;
        if(currSum == sum){		//递归的出口
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j=0; j < n; j++){
                if(visited[j]){
                    list.add(arr[j]);
                }
            }
            lists.add(list);
            return;
        }
        if(n >= arr.length)
            return;
        for(int i=n;i< arr.length;i++){
            if(!visited[i]){
                currSum += arr[i];
                visited[i] = true;		//回溯法思想，添加之后进行递归，递归结束还原元素的原始状态
                
                backTrack(arr, visited, i+1, currSum, sum, lists);	//i+1是递归函数变化的部分
                
                visited[i] = false;
                currSum -= arr[i];
//                while(i < arr.length-1 && arr[i] == arr[i+1])
//                    i++;
            }
        }
    }
}