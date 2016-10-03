package com.walkerwang.algorithm.huaweioj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class StringNameBeauty {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
//		int num = 2;
		String[] strArr = new String[num];
		int[] beauty = new int[num];
		for(int i=0; i<num; i++){
			strArr[i] = scanner.next().toLowerCase();
			beauty[i] =  getBeauty(strArr[i]);
		}
		
//		strArr[0] = "zhangsan";
//		strArr[1] = "lisi";
//		beauty[0] =  getBeauty(strArr[0]);
//		beauty[1] =  getBeauty(strArr[1]);
		
		for(int i=0; i<num; i++)
			System.out.println(beauty[i]);
	}
	
	static int getBeauty(String name){
		int beauty = 0;
		//<字符,次数>
		Map<Character, Integer> map = new HashMap<>();
		
		char[] chs = name.toCharArray();
		for(int i=0; i<chs.length; i++){
			char ch = chs[i];
			if(!map.containsKey(ch)){
				int count = getCount(name, ch);
				map.put(ch, count);
//				System.out.println(ch + ":" + count);
			}
		}
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue()); // 降序  
			}
		});
//		System.out.println(list);
		int count =26;
		Iterator<Map.Entry<Character, Integer>> iter = list.iterator();
		while(iter.hasNext()){
			Map.Entry<Character, Integer> entry = iter.next();
			beauty += entry.getValue()*count;
			count--;
		}
		return beauty;
	}
	
	static int getCount(String name, char ch){
		int count = 0;
		for(int i=0; i<name.length(); i++){
			if (name.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}
}
