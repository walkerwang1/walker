package com.walkerwang.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 统计文件中的单词最多的三个词，不区分大小写
 * 
 * 注意：
 * 1：大小写不区分
 * 2：开头和结尾是特殊符号（不是字符）
 *
 */
public class WordCount {

	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		String file = "D:data.dat";
		BufferedReader br = new BufferedReader(new FileReader(file));
		Map<String, Integer> map = new HashMap<>();
		String filter = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String line = null;
		while((line = br.readLine()) != null) {
			
			String[] strs = line.trim().toLowerCase().split(" ");
			
			for(String str : strs) {
				String ch1, ch2;
				if(str.length() > 1){
					ch1 = str.substring(str.length()-1);	//结尾是特殊符号
					ch2 = str.substring(0, 1);	//开头是特殊符号
					if (filter.indexOf(ch1.charAt(0)) < 0) {
						str = str.substring(0, str.length()-1);
					}
					if (filter.indexOf(ch2) < 0) {
						str = str.substring(1);
					}
				}
				if (map.containsKey(str)) {
					map.put(str, map.get(str) + 1);
				} else {
					map.put(str, 1);
				}
			}
		}
		
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
		    @Override  
		    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
		         return o2.getValue().compareTo(o1.getValue()); // 降序  
		    }  
		});
		
		int count = 0;
		for (Map.Entry<String, Integer> entry : list) {  
			count++;
//			if (count > 3) {
//				break;
//			}
		    System.out.println(entry.getKey() + ":" + entry.getValue()); 
		} 
		
		long endTime = System.currentTimeMillis();
		System.out.println();
		System.out.println("time:" + (endTime - startTime));
	}
}
