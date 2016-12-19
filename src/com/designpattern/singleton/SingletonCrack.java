package com.designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * 测试单例模式，通过反射和序列化方式破解单例模式
 * @author walkerwang
 *
 */
public class SingletonCrack {
	public static void main(String[] args) throws Exception {
		
		char[] chs = {'a','b','c'};
		char[] chs2 = new char[3];
		char[] chs3 = new char[] {'a','b','c'};
		System.out.println(chs3);
		
		//通过反射破解单例模式
//		throughReflect();
		
		throughSerialize();
	}

	//通过反射的方式直接调用私有化构造器，创建多个实例
	public static void throughReflect() throws Exception {
		LazySingleton2 singleton1 = LazySingleton2.getInstance();
		LazySingleton2 singleton2 = LazySingleton2.getInstance();
		System.out.println(singleton1);
		System.out.println(singleton2);
		
		//反射1
		Class<LazySingleton2> clazz = (Class<LazySingleton2>)Class.forName("com.designpattern.singleton.LazySingleton2");
		//反射2
		Class<LazySingleton2> clazz2 = (Class<LazySingleton2>)singleton1.getClass();
		Constructor<LazySingleton2> c = clazz.getDeclaredConstructor(null);
		
		c.setAccessible(true);	//设置构造器为可访问的
		LazySingleton2 singleton3 = c.newInstance();
		LazySingleton2 singleton4 = c.newInstance();
		System.out.println(singleton3);
		System.out.println(singleton4);
	}
	
	//通过反序列化的方式创建多个对象
	public static void throughSerialize() throws Exception {
		LazySingleton2 singleton1 = LazySingleton2.getInstance();
		System.out.println(singleton1);
		
		//序列化
		FileOutputStream fos = new FileOutputStream("d:/a.txt");
		ObjectOutputStream oos =new ObjectOutputStream(fos);
		oos.writeObject(singleton1);
		oos.close();
		fos.close();
		
		//反序列化（反序列化一个新的实例对象出来了）
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("d:/a.txt"));
		LazySingleton2 newSingleton = (LazySingleton2) ois.readObject();
		System.out.println(newSingleton);
	}
}

class LazySingleton2 implements Serializable {
	
	private static LazySingleton2 instance = null;
	
	private LazySingleton2() {
		//防止反射破解
		if (instance != null) {
			try {
				throw new RuntimeException();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static LazySingleton2 getInstance() {
		if (instance == null) {
			instance = new LazySingleton2();
		}
		return instance;
	}
	
	//反序列化时直接调用instance对象，如果定义了readResolve方法则直接返回此方法指定的对象，
	//而不需要单独再创建新对象
	private Object readResolve() throws Exception {
		return instance;
	}
}