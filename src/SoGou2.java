import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class SoGou2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
			int n = Integer.valueOf(reader.readLine());
			double arr[] = new double[n];
			
			int k = 0; 
			while(k < n){
				arr[k] = Double.valueOf(reader.readLine());
				k++;
			}
			
			DecimalFormat df = new DecimalFormat(".00000000");
			
			double maxValue = 0.00000000;
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = i+1; j < arr.length; j++) {
					double value = Math.abs(arr[i] - arr[j]);
					if (value > 180.0) {
						value = 360 - value;
					}
					if (value > maxValue) {
						maxValue = value;
					}
					if (maxValue == 180.0) {
						break;
					}
				}
			}
//			System.out.println(df.format(maxValue));
			
			System.out.printf("%.8f", maxValue);
		}
	}
