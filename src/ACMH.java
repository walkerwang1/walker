import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACMH {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			List<List<Integer>> allList = new ArrayList<>();
			List<Integer> list;
			int n = Integer.valueOf(cin.nextLine());
			for (int i = 0; i < n; i++) {
				list = new ArrayList<>();
				String[] strs = cin.nextLine().split(" ");
				list.add(Integer.valueOf(strs[0]));
				list.add(Integer.valueOf(strs[1]));
				allList.add(list);
			}
			
			//确定对称轴
			boolean flag = false;
			int val = Integer.MAX_VALUE;
			for(int i = 0; i < allList.size()-1; i++) {
				List<Integer> list1 = allList.get(i);
				for(int j = i+1; j < allList.size(); j++) {
					List<Integer> list2 = allList.get(j);
					if (list1.get(1).equals(list2.get(1))) {
						val = (list1.get(0) + list2.get(0)) /2;
						flag = true;
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			if (!flag) {
				System.out.println("NO");
				break;
			}

			int count = allList.size();
	
			for (int i = 0; i < allList.size(); i++) {
				list = allList.get(i);
				List<Integer> backList = backList(list, val);
				if (!allList.contains(backList)) {
					System.out.println("NO");
					break;
				} else {
					if (list.equals(backList)) {
						count--;
					} else {
						count = count - 2;
					}
				}
				if (count == 0) {
					System.out.println("YES");
					break;
				}
			}
		}
	}

	public static List<Integer> backList(List<Integer> list, int val) {
		List<Integer> newList = new ArrayList<>();
		newList.add(2*val - list.get(0));
		newList.add(list.get(1));
		return newList;
	}
}
