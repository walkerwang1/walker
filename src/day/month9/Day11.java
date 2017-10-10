package day.month9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day11 {

	public static void main(String[] args) {
		Day11 day11 = new Day11();
		
		int[] arr = {1, 1, 1, 5, 5, 10, 50, 50, 50, 500, 500 };
		int n = 11;
		int sum = 74;
		day11.comp(arr, sum);
		
		/*boolean[] visited = new boolean[n];
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		backTrack(arr, visited, 0, 0, sum, lists);
		int min_len = Integer.MAX_VALUE;
		System.out.println(lists);
		if (lists.size() == 0) {
			System.out.println("NOWAY");
			return;
		}
		for(ArrayList<Integer> list : lists) {
			if (list.size() < min_len) {
				min_len = list.size();
			}
		}
		System.out.println(min_len);*/
	}
	
	/*
	 * 回溯法
	 */
	public static void backTrack(int[] arr, boolean[] visited, int n, 
            int currSum, int sum, ArrayList<ArrayList<Integer>> lists){
        if(currSum > sum)
            return;
        
        if(currSum == sum){		
        	/*打印输出*/
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j=0; j < n; j++){
                if(visited[j]){
                    list.add(arr[j]);
                }
            }
            if (!lists.contains(list)) {
            	lists.add(list);
			}
            return;
        }
        if(n >= arr.length)
            return;
        
        /*回溯的主体*/
        for(int i=n;i< arr.length;i++){
            if(!visited[i]){
                currSum += arr[i];
                visited[i] = true;		
                
                backTrack(arr, visited, i+1, currSum, sum, lists);	
                
                visited[i] = false;
                currSum -= arr[i];
            }
        }
    }
	
	
	/*
	 * 
	 */
	public void comp(int[] arr, int n) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		int count = 0;
		int len = list.size();
		while(n >= 0) {
			//找到第一个比n大的数
			int i = len-1;
			if (i < 0) {	//list为空时，此时无法比较
				count = -1;
				break;
			}
			while(n < list.get(i)) {
				i--;
			}			
			count++;
			if (n == list.get(i)) {
				break;
			}
			n = n - list.get(i);
			int j = len-1;
			while (j >= i) {	//确定最大的比n小的数后，将i后的数从list中移除
				list.remove(j);
				len = list.size();
				j = len-1;
			}
			if (n < 0) {
				count = -1;
				break;
			}
			len = list.size();
		}
		System.out.println(count);
	}
}
