package com.walkerwang.designpattern;

/*
 * 设计模式——单例模式
 * 
 * static确保唯一性
 */
public class Singleton {

	public static void main(String[] args) {
		
	}
}

/*
 * 饿汉式单例模式
 * 
 * 特点：空间换时间、非线程安全
 * 类加载时就创建了EagerSingleton对象
 */
class EagerSingleton {
	
	private static EagerSingleton instance = new EagerSingleton();
	
	//私有构造器
	private EagerSingleton () {}
	
	//静态工厂方法
	public static EagerSingleton getInstance() {
		return instance;
	}
}


/*
 * 懒汉式单例模式
 * 
 * 特点：时间换空间，线程安全
 */
class LazySingleton {
	
	private static LazySingleton instance = null;
	
	//私有构造方法
	private LazySingleton() {}
	
	//静态工厂方法
	public static synchronized LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}

/*
 * Lazy initialization holder class模式（类级内部类，延迟加载）
 * 
 * 特点：线程安全，getInstance()不需要同步
 * 延迟加载：JVM加载一个类时，其内部类不会被加载。
 */
class InnerClassSingleton {
	
	private InnerClassSingleton(){}
	
	//类级内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例没有绑定关系，
	//而且只有被调用时才会装载，从而实现了延迟加载。
	private static class SingletonHolder {
		//静态初始化，由JVM来保证线程安全
		private static InnerClassSingleton instance = new InnerClassSingleton();
	}
	
	public static InnerClassSingleton getInstance() {
		//域的访问
		return SingletonHolder.instance;
	}
}

/*
 * 双重检查加锁
 * 
 * 特点：线程安全，性能（时间/空间）不受太大影响
 * 
 * JVM对于volatile关键字的实现的问题，会导致“双重检查加锁”的失败，
 * 因此“双重检查加锁”机制只只能用在java5及以上的版本。
 */
class DoubleCheckSingleton {
	private static DoubleCheckSingleton instance = null;
	
	private DoubleCheckSingleton() {}
	
	public static DoubleCheckSingleton getInstance() {
		//先检查实例是否存在，不存在则进入同步块
		if (instance == null) {
			//同步块，线程安全的创建实例
			synchronized(DoubleCheckSingleton.class) {
				//再次检查实例是否存在，不存在则真正创建
				if (instance == null) {
					instance = new DoubleCheckSingleton();
				}
			}
		}
		return instance;
	}
}


/*
 * 枚举
 * 
 * 特点：简洁、序列化
 * 并由JVM从根本上提供保障，绝对防止多次实例化，是更简洁、高效、安全的实现单例的方式。
 */
enum EnumSingleton {
	//定义一个枚举元素，代表Singleton的一个实例
	uniqueInstance;
	
	//单例可以有自己的操作
	public void singletonOperation() {
		//功能处理
	}
}
