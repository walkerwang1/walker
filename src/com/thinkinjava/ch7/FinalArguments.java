package com.thinkinjava.ch7;

class Gizmo {
	public void spin() {}
}

public class FinalArguments {
	void with (final Gizmo g) {
//		g = new Gizmo();	//Illegal -- g is final
	}
	
	void without(Gizmo g) {
		g = new Gizmo();
		g.spin();
	}
	
	void f(final int i) {
//		i++;	//Can't change
	}
	
	int g(final int i) {
		return i + 1;		//you can only read from a final primitive
	}
	
	public static void main(String[] args) {
		FinalArguments bf = new FinalArguments();
		System.out.println(bf.g(6));
	}
}
