package com.walkerwang.list;

import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class HashMapSortTest {
	public static void main(String[] args)
    {
        int data[] = { 2, 5, 2, 3, 5, 2, 3, 5, 2, 3, 5, 2, 3, 5, 2,  
                7, 8, 8, 7, 8, 7, 9, 0 };  
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : data) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			} else {
				map.put(i, 1);
			}
		}
		
		//map按值排序
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}

		});
    }
}
