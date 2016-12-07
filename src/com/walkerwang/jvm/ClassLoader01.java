package com.walkerwang.jvm;

public class ClassLoader01 {

	public static void main(String[] args) {
		System.out.println(Singleton.count_1); // 2
		System.out.println(Singleton.count_2); // 1
	}
}

/*
 * 类加载过程：加载-->验证-->准备-->解析-->初始化
 * 准备：count_1和count_2赋默认零值（准备阶段只加载类成员变量），代码块/实例变量在“初始化”阶段才初始化
 *  初始化： 
 *  (1)singleton * = new Singleton(); count_1 = 1; count_2 = 1; 
 *  (2)static int count_1;真正给静态变量赋值。 * count_1 = 1; count_2 = 0 
 *  (3)static{count_1++; count_2++;}; count_1 = 2;  * count_2 = 1;
 */
class Singleton {
	public static Singleton singleton = new Singleton();

	public static int count_1;
	public static int count_2 = 0;

	static {
		count_1++;
		count_2++;
	}

	public Singleton() {
		count_1++;
		count_2++;
	}

	public static Singleton getInstance() {
		return singleton;
	}

}


