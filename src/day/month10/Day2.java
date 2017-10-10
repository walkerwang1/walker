package day.month10;

import java.util.HashMap;
import java.util.Map;

public class Day2 {
	
	public static void main(String[] args) {
		Day2 day2 = new Day2();
		String[] list = {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"};
		day2.printList(list);
		System.out.println(day2.getLongestWord(list));
	}

	/*
	 * 求list中最长的单词，其该单词由其他单词组成
	 */
	public String getLongestWord(String[] list) {
		String[] array = sortByLength(list);	//根据单词长度排序，降序排序。
		printList(array);
		Map<String, Integer> map = new HashMap<>();
		for(String str : array) {
			map.put(str, 1);
		}
		
		/*从i=0到i=array.length挨个开始切换单词*/
		for(int i = 0; i < array.length; i++) {
			String str = array[i];
			//把字符串str切分成所有可能的两半
			for(int j = 0; j < str.length(); j++) {
				String left = str.substring(0, j);
				String right = str.substring(j);
				
				//注意map获取的值为空的情况，即null。此时不能与1进行比较
				if(map.get(left) != null && map.get(left) == 1 &&
						map.get(right) != null && map.get(right) == 1) {
					return str;
				}
			}
		}
		return null;
	}
	
	/*
	 * 对字符串数组进行排序
	 */
	public String[] sortByLength(String[] list) {
		for(int i = 1; i < list.length; i++) {
			for(int j = 0; j < list.length - i; j++) {
				if (list[j].length() < list[j+1].length()) {
					String str = list[j];
					list[j] = list[j+1];
					list[j+1] = str;
				}
			}
		}
		return list;
	}
	
	public void printList(String[] list) {
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
}


