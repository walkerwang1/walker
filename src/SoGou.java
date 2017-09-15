import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class SoGou {

	public static void main(String[] args) throws Exception{
//		int n = 4;
//		double arr[] = {10.00000000, 180.00000000, 183.00000000, 198.00000000};
		
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
			int n = Integer.valueOf(reader.readLine());
			double arr[] = new double[n];
			int k = 0; 
			while(k < n){
				arr[k] = Double.valueOf(reader.readLine());
				k++;
			}
			
			DecimalFormat df = new DecimalFormat(".00000000");
			
			double maxValue = Integer.MIN_VALUE;
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr.length; j++) {
					double value = Math.abs(arr[i] - arr[j]);
					if (value > 180.0) {
						value = 360 - value;
					}
					if (value > maxValue) {
						maxValue = value;
					}
				}
			}
			System.out.println(df.format(maxValue));
		}
	}
