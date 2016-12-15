package com.walkerwang.demo;

public class StaticClassDemo {

	public static void main(String[] args) {
		new A();
		new A().new B();	//B是非静态类
		new A.C();	//C是静态类
		
	}
}

class A {
	
	class B {
		
	}
	
	static class C {
		
	}
}
