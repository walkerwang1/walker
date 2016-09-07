package com.walkerwang.demo;

class Bowl{
	public Bowl(int marker) {
		System.out.println("Bowl(" + marker +")");
	}
	void f1(int marker){
		System.out.println("f1(" + marker +")");
	}
}

class Table{
	static Bowl bowl1 = new Bowl(1);
	Table(){
		System.out.println("Table()");
		bowl2.f1(1);
	}
	void f2(int marker){
		System.out.println("f2(" + marker + ")");
	}
	static Bowl bowl2 = new Bowl(2);
}

class Cupboard{
	Bowl bowl3 = new Bowl(3);
	static Bowl bowl4 = new Bowl(4);
	public Cupboard() {
		System.out.println("Cupboard");
	}
	
	static Bowl bowl5 = new Bowl(5);
}

public class StaticDemo {
	public static void main(String[] args) {
		System.out.println("Creating new Cupboard() in main");
		new Cupboard(); 	//��ʼ���࣬������
	}
//	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();
}





