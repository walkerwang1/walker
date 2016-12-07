package com.walkerwang.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 实现ArrayList
 * @author walkerwang
 *
 */
public class ImplArrayList<E> {
	/*
	 * 分析ArrayList结构
	 * 
	 * 1：ArrayList底层实现是数组
	 * 2：构造ArrayList的初始容量怎样确定（指定大小和未指定）
	 * 
	 * 方法：
	 * add(), size(), isEmpty(), iterator(), get(), remove(), contains()/indexOf() 
	 * checkRank(), ensureCapacity()
	 */
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		TreeSet<Integer> treeSet = new TreeSet<>();
	}
	
	//存储元素的数组
	Object[] elementData;
	
	//数组的大小
	private int size;
	
	//获得数组的大小
	public int size() {
		return size;
	}
	
	//判断数据是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	
	//无参构造函数
	public ImplArrayList () {
		
	}
	
	//指定容量的有参构造函数
	public ImplArrayList (int capacity) {
		
	}
	
	//向数组中添加一个元素
	public void add(E e) {
		ensureCapacity(size+1);
	}
	
	//向数组指定索引处添加一个元素
	public void add(int index, E e) {
		rangeCheckForAdd(index);
	}
	
	//向数组添加一个集合元素
	public void addAll(Collection<? extends E> c) {
		
	}
	
	//向数组指定索引添加一个集合元素
	public void addAll(int index, Collection<? extends E> c) {
		
	}
	
	//移除元素
	public void remove(Object e) {
		
	}
	
	public void remove(int index) {
		
	}
	
	//获取元素
	public E get(int index) {
		rangeCheck(index);
		
		return null;
	}
	
	//数组是否包含某个元素
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}
	
	//元素的索引值
	public int indexOf(Object o) {
		
		return -1;
	}
	
	//确保数组容量
	public void ensureCapacity(int capacity) {
		
	}
	
	@SuppressWarnings("unchecked")
	E elementData(int index) {
		return (E)elementData[index];
	}
	
	public void rangeCheckForAdd(int index) {
		
	}
	
	public void rangeCheck(int index) {
		
	}
	
	@SuppressWarnings("unused")
	private class Itr implements Iterable<E> {

		public boolean hasNext() {
			
			return false;
		}
		
		public E next() {
			
			return null;
		}
		
		@Override
		public Iterator<E> iterator() {
			
			return null;
		}
		
	}
	
}
