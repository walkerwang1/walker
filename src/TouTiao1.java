import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TouTiao1 {

	public static void main(String[] args) {
		int n = 5;
		int m = 2;
		int c = 3;
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> tmp = new ArrayList<>();
		tmp.add(3); tmp.add(1); tmp.add(2); tmp.add(3);
		list.add(tmp);
		
		
		ArrayList<Integer> tmp1 = new ArrayList<>();
		tmp1.add(0);
		list.add(tmp1);
		
		ArrayList<Integer> tmp2 = new ArrayList<>();
		tmp2.add(2); tmp2.add(2); tmp2.add(3);
		list.add(tmp2);
		
		ArrayList<Integer> tmp3 = new ArrayList<>();
		tmp3.add(1);  tmp3.add(2);
		list.add(tmp3);
		
		ArrayList<Integer> tmp4 = new ArrayList<>();
		tmp4.add(1); tmp4.add(3);
		list.add(tmp4);
		
		
		//记录每一种颜色出现的次数
		Map<Integer, HashSet<Integer>> map = new HashMap<>();
			
		for(int i = 0; i < list.size(); i++) {
			ArrayList<Integer> list_i = list.get(i);
			for(int j = 0; j < list_i.size(); j++) {
				int color = list_i.get(j);
				
			}
		}
	}
}
