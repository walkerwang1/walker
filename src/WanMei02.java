import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WanMei02 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		int num = Integer.valueOf(in.nextLine());
		String[] str1 = in.nextLine().split(" ");
		for(int i = 0; i < num; i++) {
			list1.add(Integer.valueOf(str1[i]));
		}
		String[] str2 = in.nextLine().split(" ");
		for(int i = 0; i < num; i++) {
			list2.add(Integer.valueOf(str2[i]));
		}
		
		int i=0, j=0;
		int count = 0;
		while(i < list1.size() && j < list2.size()) {
			int a  = list1.get(i);
			int b = list2.get(j);
			while(a < b) {
				j++;
				b = list2.get(j);
			}
			if (a > b) {
				count++;
				list1.remove(i);
				list2.remove(j);
//				i++;
//				j++;
			}
		}
//		System.out.println(count);
		
		int count2 = 0;	//平均次数
		for(int m = 0; m < list1.size(); m++){
			for(int n = 0; n < list2.size(); n++) {
				if (list1.get(m) == list2.get(n)) {
					count2++;
					list1.remove(m);
					list2.remove(n);
				}
			}
		}
//		System.out.println(count2);
		
		System.out.println((count - (num-count-count2))*100);
	}
}
