package day;

import java.util.ArrayList;
import java.util.HashMap;

public class Day11 {

	public static void main(String[] args) {
		/*int[] arr = {1, 1, 1, 5, 5, 10, 50, 50, 50, 500, 500 };
		int n = 11;
		int sum =620;
		boolean[] visited = new boolean[n];
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
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 11);
		System.out.println(map.get(0));
		System.out.println(map.get(1));
	}
	
	/*
	 * 回溯法
	 */
	public static void backTrack(int[] arr, boolean[] visited, int n, 
            int currSum, int sum, ArrayList<ArrayList<Integer>> lists){
        if(currSum > sum)
            return;
        if(currSum == sum){		
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
}
