import java.util.ArrayList;
import java.util.Scanner;

public class qunaer1 {
	public static void main(String[] args) {
		
		//3 2 1 3 0 2 620
		Scanner in = new Scanner(System.in);
		String[] strs = in.nextLine().split(" ");
		int sum = Integer.valueOf(strs[strs.length-1]);
		int n = 0;
		for(int i = 0; i < strs.length - 1; i++) {
			n += Integer.valueOf(strs[i]);
		}
		int[] arr = new int[n];
		int m = 0;
		
		int j = 1;
		while(j <= Integer.valueOf(strs[0])) {
			arr[m++] = 1;
			j++;
		}
		j = 1;
		while(j <= Integer.valueOf(strs[1])) {
			arr[m++] = 5;
			j++;
		}
		j = 1;
		while(j <= Integer.valueOf(strs[2])) {
			arr[m++] = 10;
			j++;
		}
		j = 1;
		while(j <= Integer.valueOf(strs[3])) {
			arr[m++] = 50;
			j++;
		}
		j = 1;
		while(j <= Integer.valueOf(strs[4])) {
			arr[m++] = 100;
			j++;
		}
		j = 1;
		while(j <= Integer.valueOf(strs[5])) {
			arr[m++] = 500;
			j++;
		}
		for(int i =0; i < arr.length;i ++)
		System.out.print(arr[i] + " ");
		System.out.println();
		
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
		System.out.println(min_len);
		
	}
	
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
            lists.add(list);
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
