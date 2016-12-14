package com.walkerwang.list;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 分析并实现HashSet
 * @author walkerwang
 *
 */
public class ImplHashSet {
	
	/*
	 * 1-特点
	 * 	元素无序、不可重复（怎样体现无序、不可重复的？）
	 *  hash实现，故添加进去的元素无序
	 *  底层是HashMap实现的，element即为HashMap的key，所以不可重复
	 */

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=1; i<=20; i++) {
			set.add(i);
		}
		System.out.println(set.getClass());
		System.out.println(set);
		System.out.println(set.size());

		LinkedHashSet<Integer> link = new LinkedHashSet<>();
		for(int i=1; i<=20; i++) {
			link.add(i);
		}
		System.out.println(link.getClass());
		System.out.println(link);
		System.out.println(link.size());
		
		Object object1 = new Object();
		Object object2 = new Object();
		System.out.println(object1);
		//输出的格式是怎样控制的，getClass()是native方法。“class java.lang.Object”
		System.out.println(object1.getClass());
		System.out.println(object2);
		System.out.println(object2.toString());
	}
}
