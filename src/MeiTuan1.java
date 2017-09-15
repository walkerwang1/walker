import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeiTuan1 {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		String nStr = in.nextLine();
		String string = in.nextLine();
			
		String[] arr = string.split(" ");
			
		int n = Integer.valueOf(nStr);
			
		int count = 0;
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			String pre = arr[i];
				for(int j = 0; j < arr.length; j++) {
					if (i != j) {
						String pos = arr[j];
						String str = pre + pos;
						
						String maxStr = String.valueOf(Integer.MAX_VALUE);
						
						if (str.length() < maxStr.length()) {
							int v = Integer.valueOf(str);
							if (v % 7 ==0 && !list.contains(v)) {
								list.add(v);
								count++;
							}
						} else if (str.length() == maxStr.length()) {
							if(str.compareTo(maxStr) < 0) {
								int v = Integer.valueOf(str);
								if (v % 7 ==0 && !list.contains(v)) {
									list.add(v);
									count++;
								}
							}
						}
					}
				}
			}
			System.out.println(count);
//			System.out.println(list);
		}
	}
