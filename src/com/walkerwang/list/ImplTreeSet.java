package com.walkerwang.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class ImplTreeSet {

	public static void main(String[] args) {
		System.out.println("---------------TreeSet---------------");
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("1");
		treeSet.add("2");
		treeSet.add("22");
		treeSet.add("23");
		
		Iterator<String> iter = treeSet.iterator();
		while(iter.hasNext()) {
			String it = iter.next();
			System.out.println(it);
		}
		
		System.out.println("--------------TreeMap------------------");
		Map<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("1", 222);
		treeMap.put("2", 222);
		treeMap.put("3", 111);
		treeMap.put("4", null);
		List<Map.Entry<String, Integer>> list = new ArrayList<>(treeMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (o1.getValue() == o2.getValue()) {
					return o2.getKey().compareTo(o1.getKey());
				}
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for(Map.Entry<String, Integer> sublist : list) {
			System.out.println(sublist.getKey() + "=" + sublist.getValue());
		}
	}
}
