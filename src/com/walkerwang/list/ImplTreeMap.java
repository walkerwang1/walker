package com.walkerwang.list;

import java.util.Map;
import java.util.TreeMap;

/**
 * 实现TreeMap
 * @author walkerwang
 *
 */
public class ImplTreeMap {

	/*
	 * 问题
	 * 1：TreeMap底层结构
	 * 2：怎样保证有序的（put()时直接根据key进行插入）
	 */
	public static void main(String[] args) {
		Map<Integer, String> treemap = new TreeMap<>();
		treemap.put(2, "2");
		treemap.put(1, "11");
		treemap.put(3, "3");
		treemap.put(5, "1");
		treemap.put(4, "20");
		treemap.get(1);
		for(Map.Entry<Integer, String> entry : treemap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
