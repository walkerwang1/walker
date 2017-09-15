import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int len1 = Integer.valueOf(scan.nextLine());
		String str1 = scan.nextLine().replace(" ", "");
		int len2 = Integer.valueOf(scan.nextLine());
		String[] array = new String[len2];
		for(int i = 0; i < len2; i++){
			array[i] = scan.nextLine().replace(" ", "");
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		String str = "";
		
		for(int i = 0; i < len2; i++ ){
			int a = 0;
			int l = (int)(array[i].charAt(0)) - 48;
			int r = (int)(array[i].charAt(1)) - 48;
			int k = (int)(array[i].charAt(2)) - 48;
			
			for(int m = l; m <= r; m++){
				if((int)(str1.charAt(m - 1)) - 48 == k){
					a++;
				}	
			}
			
//			map.put(i, a);
			
			str = str + a + "\n";
		}
		
		System.out.println(str);
	}
}
