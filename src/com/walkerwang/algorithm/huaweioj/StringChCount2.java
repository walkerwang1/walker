package com.walkerwang.algorithm.huaweioj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StringChCount2 {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String string = scanner.nextLine();
		String string = "aababc cB BA22Aadd";
		String resultStr = count(string);
		System.out.println(resultStr);
	}

	static String count(String str) {
		if (str == null) {
			return null;
		}
		StringBuilder sBuilder = new StringBuilder();
		Map<Character, Integer> map = new HashMap<>();

		char[] chs = str.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			char ch = chs[i];
			if ((ch>=65 && ch<=90) || (ch>=97 && ch<=122) || 
					(ch == ' ') || (ch>=48 && ch<=57)) {
				if (!map.containsKey(ch)) {
					int count = getCount(str, ch);
					map.put(ch, count);
				}
			}
		}
		List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				if(o1.getValue() == o2.getValue()){
					return o1.getKey().compareTo(o2.getKey());
				}
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		Iterator<Map.Entry<Character, Integer>> iter = list.iterator();
		while(iter.hasNext()){
			Map.Entry<Character, Integer> entry = iter.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
			sBuilder.append(entry.getKey());
		}
		return sBuilder.toString();
	}
	
	static int getCount(String str, char ch){
		int count = 0;
		for(int i=0; i<str.length(); i++){
			if (str.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}
}
