

import java.util.Scanner;

public class ACM10 {
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()) {
			int row = Integer.valueOf(cin.nextLine());
			for(int i = 0; i < row; i++) {
				String[] strs = cin.nextLine().split(" ");
				int m = Integer.valueOf(strs[0]);
				int n = Integer.valueOf(strs[1]);
				System.out.println(numCount(m, n));
			}
		}
	}

	static int numCount(int m, int n)  
	{  
	    if(m == 0 || n == 1)  
	        return 1;  
	    if(m < n)  
	        return numCount(m, m);  
	    return numCount(m, n-1) + numCount(m-n, n);  
	}
}


