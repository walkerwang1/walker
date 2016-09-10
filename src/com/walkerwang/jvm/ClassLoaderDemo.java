package com.walkerwang.jvm;

public class ClassLoaderDemo {

	public static void main(String[] args) {
		System.out.println("应用程序类加载器：" + ClassLoader.getSystemClassLoader());
		System.out.println(System.getProperty("java.class.path"));
		
		String aString  = "wang";
		System.out.println(aString.getClass().getName());
		System.out.println(aString.getClass().getClassLoader());
	}
}
