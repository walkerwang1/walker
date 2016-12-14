package com.walkerwang.jvm;

public class TestClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader1 = new FileSystemClassLoader("d:/test");
//		FileSystemClassLoader loader2 = new FileSystemClassLoader("d:/test");
		
		Class<?> class1 = loader1.loadClass("com.walkerwang.jvm.HeapOOM");
		Class<?> class2 = loader1.loadClass("com.walkerwang.jvm.FileSystemClassLoader");
		Class<?> class3 = loader1.loadClass("java.lang.String");
		
		System.out.println(class1.hashCode());
		System.out.println(class2.hashCode());
		System.out.println(class1.getClassLoader());
		System.out.println(class2.getClassLoader());
		System.out.println(class3.getClassLoader());
		
		System.out.println();
		System.out.println("线程名字：" + Thread.currentThread().getName());
		System.out.println("" + Thread.currentThread().getContextClassLoader());
		System.out.println(Thread.currentThread().getClass());
	}
}
