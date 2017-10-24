import java.util.Scanner;

public class ACM11 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = Integer.valueOf(cin.nextLine());
		
		int[][] matrix = new int[n][n];
		for(int i = 0; i < n; i++) {
			String[] strs = cin.nextLine().split(" ");
			for(int j = 0; j < n; j++) {
				matrix[i][j] = Integer.valueOf(strs[j]);
			}
		}
		
		if(matrix==null || matrix.length==0)
            return;
        int max=0;
        int col=n;
        int row=n;     
        for(int i=0;i<row;i++)
        {
            int arr[]=new int[col];
            for(int j = i;j < row;j++)
            {
                for(int k=0;k<col;k++)
                {
                    arr[k] += matrix[j][k];
                }
                
                int newMax = 0;
                int newSum = 0;
                for(int m = 0; m < arr.length; m++) {
                	if (newSum > 0) {
						newSum += arr[m];
					} else {
						newSum = arr[m];
					}
                	if (newSum > newMax) {
						newMax = newSum;
					} 
                }
                
                if (newMax > max) {
					max = newMax;
				}
            }
        }
        System.out.println(max);
    }
}
