package com.designpattern.prototype;

/**
 * 测试普通new方式创建对象和clone方式创建对象的效率差异，
 * 如果需要短时间内创建大量对象，并且new的过程比较耗时，则可以考虑使用原型模式。
 * @author walkerwang
 *
 */
public class Client3 {

	public static void main(String[] args) throws CloneNotSupportedException {
		testNew(1000);
		testClone(1000);
	}
	
	public static void testNew(int size) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < size; i++) {
			Laptop laptop = new Laptop();
		}
		long end = System.currentTimeMillis();
		System.out.println("new的方式创建耗时：" + (end-start) + "ms");
	}
	
	public static void testClone(int size) throws CloneNotSupportedException {
		long start = System.currentTimeMillis();
		Laptop laptop = new Laptop();
		for(int i = 0; i < size; i++) {
			Laptop cloneLaptop = (Laptop)laptop.clone();
		}
		long end = System.currentTimeMillis();
		System.out.println("clone的方式创建耗时：" + (end - start) + "ms");
	}
}


class Laptop implements Cloneable {
	
	public Laptop() {
		try {
			Thread.sleep(10);	//模拟创建对象耗时操作
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		return obj;
	}
}