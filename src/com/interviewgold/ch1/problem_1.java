package com.interviewgold.ch1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 判断一个字符串中是否每个字符全都不一样
 * @author walkerwang
 *
 */
public class problem_1 {
	public static void main(String[] args) {
		String str = "wangkaang";
		System.out.println(new problem_1().solution01(str));;
	}
	
	/*
	 * 1-HashMap统计每个字符出现的次数
	 */
	public boolean solution01(String str) {
		boolean ret = true;		//true-字符全都不同，false-有相同的两个字符
		char[] chs = str.toCharArray();
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<chs.length; i++) {
			char ch = chs[i];
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch)+1);
			} else {
				map.put(ch, 1);
			}
		}
		Set<Map.Entry<Character,Integer>> set = map.entrySet();
		Iterator<Map.Entry<Character,Integer>> iter = set.iterator();
		while(iter.hasNext()) {
			Map.Entry<Character,Integer> entry = iter.next();
			//统计map中每个key出现的次数，扩展，对map进行排序（先对value排序，若value相同则对key排序）
//			System.out.println(entry.getKey()+":" +entry.getValue());	
			if(entry.getValue() > 1) {
				ret = false;
				return ret;		//字符串不全相同
			}
		}
		
		/*List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				if(o2.getValue() == o1.getValue()) {
					return o1.getKey().compareTo(o2.getKey()); 	//value相同对key进行升序排序
				}
				return o2.getValue().compareTo(o1.getValue());	//对value进行降序排序
			}
		});
		for(Map.Entry<Character, Integer> entry : list) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}*/
		return ret;
	}
	
	/*
	 * 2-直接遍历；对每个字符遍历，判断它与后面的字符是否一样
	 */
}
