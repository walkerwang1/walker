package com.walkerwang.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class test extends Object {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "kang";
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		for(int i = 0; i < 100; i++) {
			System.out.println(random.nextDouble());
		}
	}
}
