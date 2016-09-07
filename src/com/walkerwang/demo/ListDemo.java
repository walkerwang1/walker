package com.walkerwang.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Book{
	private String name;
	private double price;

	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "书名:" + this.name + "; 价格:" + this.price + "\n";
	}
}

/*TreeSet,Comparable比较，不合适
 * class Book implements Comparable<Book>{
	private String name;
	private double price;

	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}

	// 重写equals()方法
	
	 * @Override public boolean equals(Object obj) { if (this == obj) { return
	 * true; } if(obj == null){ return false; } if(!(obj instanceof Book)){
	 * return false; } Book book = (Book)obj; if(this.name.equals(book.name) &&
	 * this.price == book.price){ return true; } return false; }
	 

	@Override
	public String toString() {
		return "书名:" + this.name + "; 价格:" + this.price + "\n";
	}

	@Override
	public int compareTo(Book o) {
		if(this.price > o.price){
			return 1;
		}else if (this.price < o.price) {
			return -1;
		}else {
			return this.name.compareTo(o.name);		//调用了String类的比较大小
		}
	}
}*/

public class ListDemo {
	public static void main(String[] args) {
//		testList();		//需要复写equals()方法
//		testSet();
		testMap();
	}

	//测试List接口
	public static void testList() {
		List<Book> list = new ArrayList<Book>();
		list.add(new Book("Java", 22));
		list.add(new Book("C", 2));
		list.add(new Book("C++", 22));
		list.remove(new Book("C++", 22));
		System.out.println(list);
	}
	//测试Set接口
	public static void testSet(){
		Set<Book> all = new HashSet<Book>();
		all.add(new Book("Java开发", 79.8));
		all.add(new Book("Java开发", 79.8));	//全部信息重复
		all.add(new Book("JSP开发", 79.8));	//价格信息重复
		all.add(new Book("Android开发", 89.8));	//都不重复
		System.out.println(all);
	}
	//测试Map接口
	public static void testMap(){
		Map<String, Integer> map = new HashMap<>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		//将Map集合变为Set集合，目的是为了使用iterator()方法
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iter = set.iterator();
		while(iter.hasNext()){
			Map.Entry<String, Integer> entry = iter.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		
	}
}
