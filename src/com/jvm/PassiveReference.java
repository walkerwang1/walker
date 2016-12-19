package com.jvm;

/**
 * 被动引用的三种情况
 * @author walkerwang
 *
 */
public class PassiveReference {

	public static void main(String[] args) {
		System.out.println(SubClass.value);		//不会初始化子类SubClass
		
		ArrayClass ac1 = new ArrayClass();	//初始化ArrayClass类
		//这个应该跟数组的数组的结构有关系
		ArrayClass[] ac2 = new ArrayClass[10];	//不会初始化ArrayClass类
		
		System.out.println(ConstClass.HELLOWORLD);
	}
}

/*
 * 被动使用类字段演示一：
 * 通过子类引用父类的静态字段，不会导致子类初始化
 * 
 * 输出结果：
 * SuperClass init!
 * 123
 * 
 * 对于静态字段，只有直接定义了这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静态字段，
 * 只会触发父类的初始化而不会触发子类的初始化。至于是否要触发子类的加载和验证，在虚拟机规范中并未
 * 明确规定，这点取决于虚拟机的具体实现。
 */
class SuperClass {
	static {
		System.out.println("SuperClass init!");
	}
	
	public static int value = 123;
}

class SubClass extends SuperClass {
	static {
		System.out.println("SubClass init!");
	}
}

/*
 * 被动使用类字段演示二：
 * 通过数组定义来引用类，不会触发此类的初始化
 */
class ArrayClass {
	static {
		System.out.println("ArrayClass init!");
	}
	
//	ArrayClass ac1 = new ArrayClass();	//初始化ArrayClass类
//	ArrayClass[] ac2 = new ArrayClass[10];	//不会初始化ArrayClass类
}

/*
 * 被动使用字段演示三：
 * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义类常量的类，因此不会触发
 * 定义常量的类的初始化
 * 
 * 虽然Java源码中引用了ConstClass类中的常量HELLOWORLD，但其实在编译阶段通过常量传播优化，
 * 已经将此常量的值"hello world"存储到PassiveReference类的常量池中，以后PassiveReference
 * 对常量的ConstClass.HELLOWORLD的引用实际都被转化为PassiveReference类对自身常量池的引用。
 */
class ConstClass {
	static {
		System.out.println("ConstClass init");
	}
	
	//如果不是final常量，调用HELLOWORLD会初始化ConstClass类
	public static final String HELLOWORLD = "hello world";
}
