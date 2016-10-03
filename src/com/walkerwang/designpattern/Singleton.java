package com.walkerwang.designpattern;

/*
 * 设计模式1：单例模式
 */
public class Singleton {
	
	/*
	 * 饿汉式单例
	 * 
	 * 私有构造方法和static来确定唯一性。
		缺点：何时产生实例 不好控制 
		虽然我们知道，在类Singleton第一次被加载的时候，就产生了一个实例。
		但是如果这个类中有其他属性
	 */
	/*
	private Singleton() {
		System.out.println("Singleton is created");
	}
	private static Singleton instance = new Singleton();
	public static Singleton getInstance() {
		return instance;
	}
	*/
	
	/*
	 * 懒汉式单例
	 
	 让instance只有在调用getInstance()方式时被创建，并且通过synchronized来确保线程安全。
	这样就控制了何时创建实例。
	这种方法是延迟加载的典型。
	但是有一个问题就是，在高并发的场景下性能会有影响，虽然只有一个判断就return了，但是在并发量很高的情况下，或多或少都会有点影响，因为都要去拿synchronized的锁。
	 */
	private Singleton() {
		System.out.println("Singleton is create");
	}
	
	private static Singleton instance = null;
	public static synchronized Singleton getInstance() {
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
}

/*
 *3-静态内部类 static nested class
 *每次去拿synchronized的锁会影响并发量
 */
class StaticSingleton {
	private StaticSingleton () {
		System.out.println("StaticSingleton is created");
	}
	
	/*
	 * 加载一个类时，其内部类不会被加载。这样保证了只有调用getInstance()时才会产生实例，控制了生成实例的时间，实现了延迟加载。
	 * 并且去掉了synchronized，让性能更优，用static来确保唯一性。
	 */
	private static class SingletonHolder {
		private static final StaticSingleton instance = new StaticSingleton();
	}
	
	private static StaticSingleton getInstance() {
		return SingletonHolder.instance;
	}
}
