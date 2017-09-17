import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class KwDa2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		String[] name = new String[n];
		int k = 0;
		while(k < n) {
			name[k] = in.nextLine();
			k++;
		}
		
		Map<String, Integer> map = new HashMap<>();
		
		int num = n*(n-1)/2;
		k = 1;
		while(k <= num) {
			String str = in.nextLine();
			int one_index = str.indexOf("-");
			int two_index = str.indexOf(":");
			int res1 = Integer.valueOf(str.substring(two_index-1, two_index));
			int res2 = Integer.valueOf(str.substring(two_index+1));
			String name1 = str.substring(one_index-1, one_index);
			String name2 = str.substring(one_index+1, one_index+2);
			if (res1 > res2) {
				if (!map.containsKey(name1)) {
					map.put(name1, 3);
				} else {
					map.put(name1, map.get(name1) + 3);
				}
			} else if(res1 == res2) {
				if (!map.containsKey(name1)) {
					map.put(name1, 1);
				} else {
					map.put(name1, map.get(name1) + 1);
				}
				if (!map.containsKey(name2)) {
					map.put(name2, 1);
				} else {
					map.put(name2, map.get(name2) + 1);
				}
			} else {
				if (!map.containsKey(name2)) {
					map.put(name2, 3);
				} else {
					map.put(name2, map.get(name2) + 3);
				}
			}
			k++;
		}
		
		//map处理
		//将map.entrySet()转换成list  
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
            //降序排序  
            @Override  
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
                //return o1.getValue().compareTo(o2.getValue());  
                return o2.getValue().compareTo(o1.getValue());  
            }  
        });  
        for(int i = 0; i < n/2; i++) {
        	System.out.println(list.get(i).getKey());
        }
	}
}
