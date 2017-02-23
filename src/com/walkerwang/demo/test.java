package com.walkerwang.demo;

import java.util.Random;

public class test extends Object {
	
	public static void main(String[] args) {
		double num1 = 10;
		double num2 = 20;
		for(int i = 1; i <= 10; i++) {
			double value = new Random().nextDouble();
			System.out.println(value * (10 -i) );
		}
	}
}
