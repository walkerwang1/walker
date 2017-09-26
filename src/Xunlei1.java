import java.util.Scanner;

public class Xunlei1 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			
			String line = in.nextLine();
			String[] strs = line.split(" ");
			int n = Integer.valueOf(strs[0]);
			int m = Integer.valueOf(strs[1]);
			System.out.println(BagProblem_Solution2(n,m));
		}
	}
	
	static int BagProblem_Solution2(int n, int m)  
	{  
		int count = 0;
	    if(n >= 120|| m >= 120)  
	        return count;  
	    if(n > m)  
	        n = m;  
	  
	    int num = 1<<n;               //枚举次数  
	    for(int i = 1; i < num; i++)  //枚举所有情况  
	    {  
	        int sum = 0;  
	        int j, k;  
	        for(j = i, k = 1; j != 0; j >>= 1, k++) //针对每种情况求和，判断是否满足条件  
	        {  
	            if((j&1) == 1)  
	                sum += k;  
	        }  
	        if(sum == m) //如果满足，打印结果  
	        {  
	        	count++;
	        	for(j = i, k = 1; j != 0; j>>=1, k++)  
	            {  
	                if((j&1) == 1)  
	                    System.out.print(k + " ");;  
	            } 
	        	System.out.println();
	        }  
	    }  
	    return count;
	}  
}
