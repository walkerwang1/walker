import java.util.Scanner;

public class Jd01 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            
            if (n < 1 || n > 100000) {
            	return;
			}
		
		int sum = 0; 
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				for(int m = 1; m <= n; m++) {
					for(int k = 1; k <= n; k++) {
						if(Math.pow(i,j) == Math.pow(m, n)) {
//							System.out.println(i +"+" + j + ":" + m + "+" + k);
							sum++;
						}
					}
				}
			}
		}
		
		System.out.println(sum % 1000000007);
        }
	}
}
