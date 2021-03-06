package com.walkerwang.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 分析并实现HashMap
 * @author walkerwang
 *
 */
public class ImplHashMap {
	/*
	 * 1-分析HashMap结构（属性，方法，类）
	 * 	拓展：关键字（final,static,transient,volatile, synchronized),内部类， 代码块
	 * 底层实现结构：数组+链表+红黑树
	 * 冲突处理方法
	 * hash()算法
	 * 
	 * 特点：
	 * 
	 * get(), put(), 
	 */
	
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>(20);
		
		int a = 5;
		int b = 10;
		int c = 15;
		a = b = c;
		System.out.println(a);System.out.println(b);System.out.println(c);
	}
}
