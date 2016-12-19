package com.jvm;

public class ActiveReference {
	
	static {
		System.out.println("main init");
	}
	
	public static void main(String[] args) {
		
		/*
		 * A init
		 */
//		A a1 = new A();
		
		/*
		 * A init
		 * 0
		 */
//		System.out.println(A.a);
		
		/*
		 * A init
		 * B init
		 */
		B b1 = new B();
	}
}

class A {
	public static int a;
	
	static {
		System.out.println("A init");
	}
}

class B extends A {
	static {
		System.out.println("B init");
	}
}
